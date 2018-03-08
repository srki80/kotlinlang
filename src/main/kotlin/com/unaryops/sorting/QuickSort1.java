package com.unaryops.sorting;

public class QuickSort1 {
    public void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quicksort(arr, low, high);
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = arr[(low + high) / 2];
        int index = partition(arr, low, high, pivot);
        quicksort(arr, low, index - 1);
        quicksort(arr, index, high);

    }

    private int partition(int[] arr, int low, int high, int pivot) {
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            swap(arr, low, high);
            low++; high--;
        }
        return low;
    }

    private void swap(int[] arr, int low, int high) {
        if (low <= high) {
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        }
    }
}

