package com.unaryops.sorting;

public class QuicksortJava {
    public void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        quickSort(arr, left, right);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);

        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            swap(arr, left, right);
            left++; right--;
        }

        return left;
    }

    private void swap(int[] arr, int left, int right) {
        if (left <= right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }
}
