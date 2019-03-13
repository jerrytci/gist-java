package com.rejerry.javagist.arithmetic;

import com.rejerry.javagist.data.RJData;

public class SortStatic {
    private static int[] array1 = new int[]{4, 2, 8, 1, 3, 9, 5, 6};

    private static void testBubble(int[] array) {
        Print.printArray(array);
        long date = System.currentTimeMillis();
        bubble(array);
        long date2 = System.currentTimeMillis();
        Print.printArray(array);
        System.out.println(date2 - date);
        System.out.println();
    }

    static void testBubble2(int[] array) {
        Print.printArray(array);
        long date = System.currentTimeMillis();
        bubble2(array);
        long date2 = System.currentTimeMillis();
        Print.printArray(array);
        System.out.println(date2 - date);
        System.out.println();
    }

    static void testQuick(int[] array) {
        Print.printArray(array);
        long date = System.currentTimeMillis();
        bubble2(array);
        long date2 = System.currentTimeMillis();
        Print.printArray(array);
        System.out.println(date2 - date);
        System.out.println();
    }

    static void testQuick() {
        Print.printArray(RJData.getIntArray());
        long date = System.currentTimeMillis();
        quick(RJData.getIntArray());
        long date2 = System.currentTimeMillis();
        Print.printArray(RJData.getIntArray());
        System.out.println(date2 - date);
        System.out.println();
    }


    static void testQuick_2() {
        Print.printArray(RJData.getIntArray());
        long date = System.currentTimeMillis();
        quickSort(RJData.getIntArray());
        long date2 = System.currentTimeMillis();
        Print.printArray(RJData.getIntArray());
        System.out.println(date2 - date);
        System.out.println();
    }

    static void testQuick2() {
        Print.printArray(RJData.getIntArray());
        long date = System.currentTimeMillis();
        quickSort2(RJData.getIntArray(), 0, RJData.getIntArray().length - 1);
        long date2 = System.currentTimeMillis();
        Print.printArray(RJData.getIntArray());
        System.out.println(date2 - date);
        System.out.println();
    }

    public static void main(String[] args) {
//        testBubble(array1);
//        testBubble2(array1);
//        testQuick(array1);

        testQuick();
        testQuick_2();
        testQuick2();
    }

    public static void QuickSort(int a[], int start, int end) {
        if (start < end) {
            int pIndex = QuickPartition(a, start, end);
            QuickSort(a, start, pIndex - 1);
            QuickSort(a, pIndex + 1, end);
        }
    }

    private static int QuickPartition(int a[], int start, int end) {
        int temp;
        int pivot = a[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                //swap a[i],apindex
                temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }
        temp = a[pIndex];
        a[pIndex] = a[end];
        a[end] = temp;
        return pIndex;
    }

    private static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    private static void quickSort2(int[] intArray, int low, int height) {
        if (low < height) {
            int middle = middle(intArray, low, height);
            quickSort2(intArray, low, middle - 1);
            quickSort2(intArray, middle + 1, height);
        }
    }

    private static int middle(int[] array, int low, int height) {
        int middle = array[low];

        while (low < height) {
            while (low < height && array[height] >= middle) {
                height--;
            }
            array[low] = array[height];
            while (low < height && array[low] < middle) {
                low++;
            }
            array[height] = array[low];
        }

        array[low] = middle;
        return low;
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
     *
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers) {
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }
}
