package com.unaryops.maps;

import java.util.LinkedHashMap;

public class HHHMap<K, V> {
    private HHHMap.Node<K, V>[] table;
    private final int DEFAULT_SIZE = 16;
    private Node<K, V> head;
    private Node<K, V> tail;
    private int size = 0;

    private static class Node<K, V> {
        private final K key;
        private final int hash;
        private V value;
        private Node<K, V> next;
        private Node<K, V> before;
        private Node<K, V> after;


        private Node(K key, int hash, V value, Node<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
            this.before = null;
            this.next = null;
        }
    }

    public void put(K key, V value) {
        if (table == null) {
            table = (Node<K,V>[]) new Node[DEFAULT_SIZE];
        }

        int hash = key.hashCode();
        int index = hash % table.length;
        Node node = new Node(key, hash, value, null);

        if (table[index] == null) {
            table[index] = node;
            if (size == 0) {
                head = node;
                tail = head;
            } else {
                node.before = tail;
                tail = node;
            }

            size++;
            return;
        }

        if (table[index].key == key) {
            table[index].value = value;
            return;
        }

        Node next = table[index].next;
        while (next != null) {
            if (next.key == key) {
                next.value = value;
                return;
            }

            next.before = tail;
            next = next.next;
        }
        size++;
        next = node;
        tail = next;
    }

    public V dequeue() {
        if (table == null) {
            throw new IllegalStateException();
        }

        int hash = head.key.hashCode();
        int index = hash % table.length;

        Node tmp = table[index];
        while (tmp != null && head.key != tmp.key) {
            tmp = tmp.next;
        }

        V value = head.value;
        head.next = null;
        head = tmp;
        return value;
    }

    public V get(K key) {
        if (table == null) {
            throw new IllegalStateException("Hash is empty");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        if (table[index].key == key) {
            return table[index].value;
        }

        Node next = table[index].next;
        while (next != null) {
            if (next.key == key) {
                return (V) next.value;
            }
        }

        return null;
    }
}
