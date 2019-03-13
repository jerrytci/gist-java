package com.rejerry.javagist.arithmetic;

import com.rejerry.javagist.data.RJData;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = RJData.getIntArray();
        Print.printArray(ints);
        new QuickSort().quickSort(ints, 0, ints.length - 1);
        Print.printArray(ints);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            Print.printArray(arr);

            if (arr[i] < arr[pivot]) {
                System.out.println("  i = " + i);
                System.out.println("  index = " + index);
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}