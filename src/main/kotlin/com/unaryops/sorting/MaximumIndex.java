package com.unaryops.sorting;

import java.util.Arrays;

public class MaximumIndex {
    public static void find(Integer[] arr) {
        Arrays.sort(arr);
        System.out.println("Result: " + (arr[arr.length - 1] - arr[0]));
    }
}
