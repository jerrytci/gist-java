package com.rejerry.javagist.leetcode;

public class twosum {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] nums = new int[]{0, 4, 3, 0};
//        int target = 0;
        int[] nums = new int[]{-3, 4, 3, 90};
        int target = 0;
        int[] res = twoSum(nums, target);
        System.out.println("res[0] = " + res[0]);
        System.out.println("res[1] = " + res[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        boolean find = false;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (find) break;

//            if (nums[i] > target) continue;

            for (int j = 1; j < nums.length && i != j; j++) {
//                if (nums[j] > target) continue;

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
}
