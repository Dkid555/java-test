package com.leetcode;

public class FindTriangularSumofanArray {
    public static int triangularSum(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] temp = nums;
        while (true) {
            int[] level = new int[temp.length - 1];
            for (int i = 0; i < level.length; ++i) {
                level[i] = (temp[i] + temp[i + 1]) % 10;
            }
            if (level.length == 1)
                return level[0];
            temp = level;
        }
    }

    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{5}));
    }
}
