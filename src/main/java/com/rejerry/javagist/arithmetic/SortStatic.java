package com.rejerry.javagist.arithmetic;

public class SortStatic {
    private static int[] array1 = new int[]{4, 2, 8, 1, 3, 9, 5, 6};

    private static void printArray(int[] array, String method, boolean begin) {
        String label = begin ? ".begin: " : ".end.result: ";
        System.out.println(method + label);

        StringBuilder res = new StringBuilder();
        for (int i : array) {
            res.append(i + ", ");
        }
        res = new StringBuilder(res.substring(0, res.length() - 1));
        System.out.println(res);
    }

    private static void testBubble(int[] array) {
        printArray(array, "bubble", true);
        bubble(array);
        printArray(array, "bubble", false);
    }
    static void testBubble2(int[] array) {
        printArray(array, "bubble", true);
        bubble2(array);
        printArray(array, "bubble", false);
    }

    public static void main(String[] args) {
        testBubble(array1);
//        testBubble2(array1);
    }


    /*冒泡排序
     * */
    private static void bubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 冒泡排序; 升序
    //num-1趟，j-1注意不要数组越界
    private static void bubble2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = array.length - 1; j >= i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
