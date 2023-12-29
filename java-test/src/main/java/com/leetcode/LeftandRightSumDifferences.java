package com.leetcode;

public class LeftandRightSumDifferences {
    public int[] leftRightDifference(int[] nums) {
        if (nums != null && nums.length > 0) {
            int n = nums.length;
            int[] lsum = new int[n];
            int[] rsum = new int[n];
            for (int i = 1, j = n - 2; i < n; i++, j--) {
                lsum[i] += lsum[i - 1] + nums[i - 1];
                rsum[j] += rsum[j + 1] + nums[j + 1];
            }
            for (int i = 0; i < n; i++) {
                nums[i] = Math.abs(lsum[i] - rsum[i]);
            }
        }
        return nums;
    }
}
