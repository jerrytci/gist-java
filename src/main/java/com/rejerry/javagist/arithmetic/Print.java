package com.rejerry.javagist.arithmetic;

class Print {
    static void printArray(int[] array, String method, boolean begin) {
        String label = begin ? ".begin: " : ".end.result: ";
        System.out.println(method + label);

        StringBuilder res = new StringBuilder();
        for (int i : array) {
            res.append(i).append(",");
        }
        res = new StringBuilder(res.substring(0, res.length() - 1));
        System.out.println(res);
    }
}
