package com.rejerry.javagist.leetcode;

import java.util.HashMap;
import java.util.Map;

public class twosum {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] nums = new int[]{0, 4, 3, 0};
//        int target = 0;
//        int[] nums = new int[]{-3, 4, 3, 90};
//        int target = 0;
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        int[] res = twoSum34(nums, target);
        System.out.println("res[0] = " + res[0]);
        System.out.println("res[1] = " + res[1]);
    }

    private static int[] twoSum34(int[] nums, int target) {
        boolean find = false;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (find) break;
            for (int j = 1; j < nums.length && i != j; j++) {
                if (nums[i] + nums[j] == target) {
                    if (i < j) {
                        res[0] = i;
                        res[1] = j;
                    } else {
                        res[1] = i;
                        res[0] = j;
                    }

                    find = true;
                    break;
                }
            }
        }
        return res;
    }

    /*25ms*/
    private static int[] twoSum25(int[] nums, int target) {
        int max = nums.length;
        for (int i = 0; i < max; i++) {
            int num1 = nums[i];
            int beta = target - num1;
            for (int j = i + 1; j < max; j++) {
                int num2 = nums[j];
                if ((num2 == beta)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*20ms*/
    private static int[] twoSum20(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;

                }

            }
        return ret;
    }

    /*3ms*/
    private static int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int diff = target - nums[index];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = index;
            } else {
                map.put(nums[index], index);
            }
        }
        return res;
    }
}
