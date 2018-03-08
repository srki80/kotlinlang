package com.unaryops.sorting;

public class MergeSortJava {
    public void sort(int [] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }


    private void mergeSort(int[] arr, int[]temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(arr, temp, left, middle);
        mergeSort(arr, temp,middle + 1, right);
        merge(arr, temp, left, right, middle);
    }

    private void merge(int[] arr, int[] temp, int left, int right, int middle) {
        // make a copy of the original array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        // left
        // right starts at the middle and goes to the end of the array
        // and current is left
        int startLeft = left;
        int startRight = middle + 1;
        int current = left;

        while (startLeft <= middle && startRight <= right) {
            if (temp[startLeft] <= temp[startRight]) {
                arr[current] = temp[startLeft];
                startLeft++;
            } else {
                arr[current] = temp[startRight];
                startRight++;
            }
            current++;
        }

        while (startLeft <=  middle) {
            arr[current] = temp[startLeft];
            startLeft++;
            current++;
        }
    }
}
