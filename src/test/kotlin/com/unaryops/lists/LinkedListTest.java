package com.unaryops.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> list = new LinkedList<>();
    @BeforeEach
    public void setup() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
    }

    @Test
    void add() {
        list.print();
    }

    @Test
    void remove() {
        list.remove(1);
        list.remove(4);
        list.print();
    }

    @Test
    void reverseEveryK() {
        list.reverse(3);
        list.print();
    }

}