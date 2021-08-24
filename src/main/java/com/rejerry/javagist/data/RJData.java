package com.rejerry.javagist.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RJData {
    public static int[] getIntArray() {
        return new int[]{4, 2, 8, 1, 3, 9, 5, 6};
    }

    public static int[] getIntArray4Quick() {
        return new int[]{4, 4, 8, 1, 3, 9, 5, 6};
    }

    public static int[] getLargeIntArray(int length) {
        int[] ints2 = new int[length];
        for (int i = 0; i < ints2.length; i++) {
            ints2[i] = randomInt();
        }
        return ints2;
    }

    public static int randomInt() {
        int max = 100;
        int min = 0;
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
