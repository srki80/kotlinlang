package com.unaryops.maps;

public class HMap<K, V> {

    public HMap.Node<K, V>[] map;
    private final int DEFAULT_SIZE = 16;
    private int CURRENT_SIZE = 16;
    private final double THRESHOLD = 0.75;
    private int size = 0;

    public static class Node<K, V> {
        private final K key;
        private final int hash;
        private Node<K, V> next;
        private V value;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;

            if (!key.equals(node.key)) return false;
            return value != null ? value.equals(node.value) : node.value == null;
        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

    public V put (K key, V value) {
        if (map == null) {
            map = (Node<K,V>[]) new Node[DEFAULT_SIZE];
        }

        if (size > size*THRESHOLD) {
//            map = resize();
        }

        int hash = key.hashCode();
        int index = hash % map.length;

        Node<K, V> node = new Node<>(key, value, hash, null);

        if (map[index] == null) {
            size++;
            map[index] = node;
            return map[index].value;
        }

        if (map[index].key == key) {
            map[index] = node;
            return map[index].value;
        }

        // conflict - add new entry
        Node<K, V> temp = map[index];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

        return temp.next.value;
    }

    private Node<K, V>[] resize() {
        CURRENT_SIZE *= 2;
        HMap.Node<K, V>[] newMap = new Node[CURRENT_SIZE];

        for (int i = 0; i < map.length; i++) {
            newMap[i] = map[i];
        }

        return newMap;
    }

    public V get (K key) {
        int hash = key.hashCode();
        int index = hash % map.length;

        if (map[index] == null) {
            throw new KeyDoesNotExist("key does not exist");
        }

        Node<K, V> temp = map[index];

        while (temp.next != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }

        return temp.value;
    }

    public boolean keyExist(K key) {
        try {
            get(key);
        } catch (KeyDoesNotExist e) {
            return false;
        }

        return true;
    }

    public int size() {
        return size;
    }
}
