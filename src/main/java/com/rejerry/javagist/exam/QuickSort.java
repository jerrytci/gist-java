package com.rejerry.javagist.exam;

import com.rejerry.javagist.arithmetic.Print;
import com.rejerry.javagist.data.RJData;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = RJData.getIntArray();
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
        System.out.println("pivot = " + pivot);
        int time = 0;
        for (int i = pivot + 1; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, pivot + 1 + time);
                time++;
            }
        }
        pivot += time;
        swap(array, low, pivot);
        System.out.println("pivot = " + pivot);
        Print.printArray(array);
        return pivot;
    }

    private void swap(int[] array, int i, int i1) {
        int temp = array[i1];
        array[i1] = array[i];
        array[i] = temp;
    }
}
