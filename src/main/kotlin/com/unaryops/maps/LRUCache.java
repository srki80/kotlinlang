package com.unaryops.maps;

import java.util.*;
import java.util.HashMap;

public class LRUCache<K, V> {
    // FIFO
    Map<K, Node> cache;
    int size;
    Node head;
    Node tail;

    public static class Node<K, V> {
        private K key;
        private V value;
        private Node previous;
        private Node next;

        public Node(K key, V value) {
            this.value = value;
            this.key = key;
        }
    }

    /*Inititalize an LRU cache with size N */
    public LRUCache(int size) {
        this.size = size;
        this.cache = new HashMap<>();
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public V get(K key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(key, node);
            return (V) node.value;
        } else {
            throw new KeyDoesNotExist("Key not in the cache");
        }
    }

    private void remove(K key, Node node) {
        if (node == head) {
            if (node.next != null)  {
                head = node.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
        } else if (node == tail ){
            tail = node.previous;
            tail.next = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        cache.remove(key);
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(key, node);
            Node newNode = new Node(key, value);
            head.previous = newNode;

        } else {
            Node node = new Node(key, value);
            if (cache.size() == size) {
//                remove();

            }
            cache.put(key, node);
        }

    }
}
