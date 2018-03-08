package com.unaryops.sorting;

import org.junit.jupiter.api.Test;


class QuicksortJavaTest {
    @Test
    void quickSort() {
        QuickSort1 quick = new QuickSort1();
        int[] arr = new int[] {9, 5, 1, 8, 6, 10, 2};
        quick.sort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    @Test
    void mergeSort() {
        MergeSort1 merge = new MergeSort1();
        int[] arr = new int[] {9, 5, 1, 8, 6, 10, 2};
        merge.sort(arr);

        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}