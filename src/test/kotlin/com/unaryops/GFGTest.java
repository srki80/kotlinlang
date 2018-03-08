package com.unaryops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GFGTest {
    @Test
    void emptySubArray() {
        GFG.subArraySum(new Integer[] {1, 2, 3, 7, 5}, 12);
        Integer arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        GFG.subArraySum(arr, 23);
        arr = new Integer[] {15, 2, 4, 8, 10, 7, 5, 23};
        GFG.subArraySum(arr, 23);
    }
}