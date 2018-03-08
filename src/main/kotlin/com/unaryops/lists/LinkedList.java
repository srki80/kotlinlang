package com.unaryops.lists;

public class LinkedList<T> {
    public Node head;
    public Node tail;

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }

    }

    public void reverse(int k) {
        Node start = head;
        reverse(k, start);
    }

    public void reverse(int k, Node node) {
        Node start = node;
        Node current = start;

        int i = 1;
        while (i < k && current.next != null) {
            current = current.next;
            i++;
        }

        i = 1;
        int j = k;
        while (i < j && current != null) {
            T tmp = (T) start.data;
            start.data =  current.data;
            current.data = tmp;
            start = start.next;
            current = current.next;
            i++; j--;
        }

        if (current == null) return;

        i = 1;
        while (i < k && start != null) {
            start = start.next;
            i++;
        }

        reverse(k, start);
    }

    public static class Node<T> {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }

    }

    public void remove(T data) {
        Node current = head;
        Node next = head.next;

        if (current.data == data) {
            head = next;
            return;
        }

        while (next != null) {
            if (next.data == data) {
                current.next = next.next;
                break;
            } else {
                current = next;
                next = next.next;
            }
        }
    }
}
