package com.unaryops;

import com.unaryops.arraysandstrings.ArraysStringsJava;
import org.junit.jupiter.api.Test;

class ArraysStringsJavaTest {
    @Test
    void replaceSpaces() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i: " + i);
            for (int j = i + 1; j < 10; j++) {
                System.out.print(" j: " + j);
            }
            System.out.println();
        }
    }
}