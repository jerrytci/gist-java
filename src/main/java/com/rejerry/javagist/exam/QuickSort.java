package com.rejerry.javagist.exam;

import com.rejerry.javagist.arithmetic.Print;
import com.rejerry.javagist.data.RJData;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = RJData.getLargeIntArray(20);
        Print.printArray(ints);
        new QuickSort().quickSort(ints, 0, ints.length - 1);
        Print.printArray(ints);
    }

    public void quickSort(int[] array, int low, int right) {
        if (low < right) {
            int pivot = quickSortRecursion(array, low, right);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    public int quickSortRecursion(int[] array, int low, int right) {
        int pivot = low;
        int time = 0;
        for (int i = pivot + 1; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, pivot + 1 + time);
                time++;
            }
        }
        pivot += time;
        swap(array, low, pivot);
        return pivot;
    }

    public int quickSortRecursionDesc(int[] array, int low, int right) {
        int pivot = right;
        int time = 0;
        for (int i = right - 1; i >= low; i--) {
            if (array[i] > array[pivot]) {
                swap(array, i, pivot - 1 - time);
                time++;
            }
        }
        pivot -= time;
        swap(array, right, pivot);
        return pivot;
    }

    private void swap(int[] array, int i, int i1) {
        int temp = array[i1];
        array[i1] = array[i];
        array[i] = temp;
    }
}
