package com.rejerry.javagist.arithmetic;

import java.util.Date;

public class SortStatic {
    private static int[] array1 = new int[]{4, 2, 8, 1, 3, 9, 5, 6};

    private static void testBubble(int[] array) {
        Print.printArray(array, "bubble", true);
        long date = System.currentTimeMillis();
        bubble(array);
        long date2 = System.currentTimeMillis();
        Print.printArray(array, "bubble", true);
        System.out.println(date2-date);
        System.out.println();
    }
    static void testBubble2(int[] array) {
        Print.printArray(array, "bubble", true);
        long date = System.currentTimeMillis();
        bubble2(array);
        long date2 = System.currentTimeMillis();
        Print.printArray(array, "bubble", false);
        System.out.println(date2-date);
        System.out.println();
    }
    static void testQuick(int[] array) {
        Print.printArray(array, "quick", true);
        long date = System.currentTimeMillis();
        bubble2(array);
        long date2 = System.currentTimeMillis();
        Print.printArray(array, "quick", false);
        System.out.println(date2-date);
        System.out.println();
    }

    public static void main(String[] args) {
        testBubble(array1);
//        testBubble2(array1);
        testQuick(array1);
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

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] >= temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }

    }

    /**
     * 快速排序
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers) {
        if(numbers.length > 0) {
            quickSort(numbers, 0, numbers.length-1);
        }
    }
}
