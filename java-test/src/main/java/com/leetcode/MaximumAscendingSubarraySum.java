package com.leetcode;

public class MaximumAscendingSubarraySum {
    public static int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1])
                sum += nums[i];
            else {
                maxSum = Math.max(maxSum, sum);
                sum = nums[i];
            }
        }
        return Math.max(maxSum, sum);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 10, 1, 8, 9, 9, 8, 9};
        System.out.println(maxAscendingSum(nums));
    }
}
