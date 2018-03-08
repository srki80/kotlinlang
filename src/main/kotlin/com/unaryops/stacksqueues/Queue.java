package com.unaryops.stacksqueues;

import sun.plugin.dom.exception.InvalidStateException;

public class Queue {
    private Node tail;
    private Node head;
    private final int size = 16;

    public Queue() {
        this.tail = null;
        this.head = null;
    }

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    public int peek() {
        if (isEmpty()) throw new InvalidStateException("Queue is empty");
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        if (head == null) {
            head = node;
        }
        tail = node;
    }

    public int remove() {
        if (isEmpty()) throw new InvalidStateException("Queue is empty");
        int val = head.data;
        head = head.next;

        if (head == null) tail = null;

        return val;
    }


}
