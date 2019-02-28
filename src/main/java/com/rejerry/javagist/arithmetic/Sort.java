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

    private void testBubble22(int[] array) {
        Print.printArray(array, "bubble22", true);
        bubble22(array);
        Print.printArray(array, "bubble22", false);
        System.out.println();
    }

    public static void main(String[] args) {
        /*
        time: 64
        bubble.end
        1,2,3,4,5,6,8,9

        bubble2
        4,2,8,1,3,9,5,6
        time: 35
        bubble2.end
        1,2,3,4,5,6,8,9

        bubble22
        4,2,8,1,3,9,5,6
        time: 36
        bubble22.end
        1,2,3,4,5,6,8,9
        */
        new Sort().testBubble(new Sort().array1);
        new Sort().testBubble2(new Sort().array1);
        new Sort().testBubble22(new Sort().array1);
    }

    /*冒泡排序
     * */
    private void bubble(int[] array) {
        int time = 0;

        for (int i = 0; i < array.length; i++, time += 1) {
            for (int j = 0; j < array.length - 1; j++, time += 1) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("time: " + time);
    }

    // 冒泡排序; 升序
    //num-1趟，j-1注意不要数组越界
    private void bubble2(int[] array) {
        int time = 0;

        for (int i = 1; i < array.length; i++, time += 1) {
            for (int j = array.length - 1; j >= i; j--, time += 1) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        System.out.println("time: " + time);
    }

    private void bubble22(int[] array) {
        int time = 0;

        for (int i = 0; i < array.length; i++, time += 1) {
            for (int j = array.length - 1; j > i; j--, time += 1) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        System.out.println("time: " + time);
    }
}
