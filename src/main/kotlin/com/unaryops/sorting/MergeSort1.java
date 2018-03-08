package com.unaryops.sorting;

public class MergeSort1 {
    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        mergesort(arr, temp, start, end);
    }

    private void mergesort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        mergesort(arr, temp, start, middle);
        mergesort(arr, temp, middle + 1, end);
        merge(arr, temp, start, end, middle);
    }

    private void merge(int[] arr, int[] temp, int start, int end, int middle) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int leftStart = start;
        int rightStart = middle + 1;
        int current = start;

        while (leftStart <= middle && rightStart <= end) {
            if (temp[leftStart] <= temp[rightStart]) {
                arr[current] = temp[leftStart];
                leftStart++;
            } else {
                arr[current] = temp[rightStart];
                rightStart++;
            }
            current++;
        }

        int remaining = middle - leftStart;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = temp[leftStart + i];
        }
    }
}
