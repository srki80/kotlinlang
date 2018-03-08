package com.unaryops.maps;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;

public class HashMapJava<K, V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {

    transient HashMapJava.Node<K,V>[] table;
    transient Set<Map.Entry<K,V>> entrySet;
    transient int size;

    public static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        Node<K, V> next;

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

            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                return true;

            return false;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V put(K key, V value) {
        if (table == null) {
            table = (Node<K,V>[]) new Node[16];
        }

        int hash = hash(key);
        int index = hash % table.length;
        if (table[index] == null) {
            table[index] = new Node<>(key, value, hash, null);
        } else {
            // loop
            table[index].next =  new Node<>(key, value, hash, null);
        }


        return value;
    }

    @Override
    public V get(Object key) {

        return (V) "";

    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Arrays.asList(table).forEach(entry -> {
            if (entry != null ) {
                while (entry.next != null) {
                   set.add(entry);
                   entry = entry.next;
                }
            }
        });
        return set;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }


}

