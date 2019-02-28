package com.rejerry.javagist.arithmetic;

public class Sort {
    private int[] array1 = new int[]{4, 2, 8, 1, 3, 9, 5, 6};

    private void testBubble(int[] array) {
        Print.printArray(array, "bubble", true);
        bubble(array);
        Print.printArray(array, "bubble", false);
        System.out.println();
    }
    private void testBubble2(int[] array) {
        Print.printArray(array, "bubble2", true);
        bubble2(array);
        Print.printArray(array, "bubble2", false);
        System.out.println();
    }

    public static void main(String[] args) {
        new Sort().testBubble(new Sort().array1);
        new Sort().testBubble2(new Sort().array1);
    }

    /*冒泡排序
     * */
    private void bubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 冒泡排序; 升序
    //num-1趟，j-1注意不要数组越界
    private void bubble2(int[] array) {
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
