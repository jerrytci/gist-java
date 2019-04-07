package com.rejerry.javagist.leetcode;

import java.util.ArrayList;
import java.util.List;

public class twosum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println("res[0] = " + res[0]);
        System.out.println("res[1] = " + res[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        List<Integer> include2 = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (num < target) {
                include2.add(num);
            }
        }

        int[] include = new int[include2.size()];
        for (int i = 0; i < include2.size(); i++) {
            include[i] = include2.get(i);
        }

        boolean find = false;
        int[] res = new int[2];
        for (int i = 0; i < include.length; i++) {
            if (find) break;
            for (int j = 0; j < include.length && i!=j; j++) {
                if(include[i] + include[j] == target){
                    res[0] = i;
                    res[1] = j;
                    find = true;
                    break;
                }
            }
        }

        return res;
    }
}
