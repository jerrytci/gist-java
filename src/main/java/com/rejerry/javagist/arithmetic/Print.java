package com.rejerry.javagist.arithmetic;

public class Print {
    public static void printArray(int[] array) {
        StringBuilder res = new StringBuilder();
        for (int i : array) {
            res.append(i).append(",");
        }
        res = new StringBuilder(res.substring(0, res.length() - 1));
        System.out.println(res);
    }
}
