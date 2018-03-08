package com.unaryops.maps;

public class HHMap<K, V> {
    private HHMap.Node<K, V>[] table;
    private final int DEFAULT_SIZE = 16;
    private int size = 0;

    private static class Node<K, V> {
        private final K key;
        private final int hash;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }
    }

    public V put(K key, V value) {
        if (table == null) {
            table =  (Node<K, V>[]) new Node[DEFAULT_SIZE];
        }

        int hash = key.hashCode();
        int index = hash % DEFAULT_SIZE;

        Node<K, V> node = new Node<>(key, value, hash, null);

        if (table[index] == null) {
            table[index] = node;
            return value;
        }

        if (table[index].key == key) {
            table[index].value = value;
            return value;
        }

        Node<K, V> temp = table[index];
        while (temp.next != null) {
            temp = temp.next;
            if (temp.key == key) {
                temp.value = value;
                return value;
            }
        }

        temp.next = node;
        return value;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % DEFAULT_SIZE;

        if (table[index].key == key) return table[index].value;

        return null;
    }


}
