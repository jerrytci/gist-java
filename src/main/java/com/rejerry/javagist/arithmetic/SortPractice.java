package com.rejerry.javagist.arithmetic;

import com.rejerry.javagist.data.RJData;

public class SortPractice {
    public static void main(String[] args) {
        int[] ints = RJData.getIntArray();
        Print.printArray(ints, "sort", true);
        int temp = -1;
        int time = 0;

        for (int i = 0; i < ints.length; i++) {
            for (int i1 = ints.length - 1; i1 > i; i1--) {
                time += 1;

                int i1less1 = i1 - 1;
                if (ints[i1] > ints[i1less1]) {
                    temp = ints[i1];
                    ints[i1] = ints[i1less1];
                    ints[i1less1] = temp;
                }
            }
        }
        System.out.println("time: " + time);
        Print.printArray(ints, "sort", false);
    }
}
