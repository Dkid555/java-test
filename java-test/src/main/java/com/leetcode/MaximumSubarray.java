package com.leetcode;


//Given an integer array nums, find the
//subarray
// with the largest sum, and return its sum.
public class MaximumSubarray {

    //First, not effective
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
            sum = 0;
        }
        return max;
    }

    //O(n)
    public static int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    //O(n)
    public static int maxSubArray3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum += val;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{5, 4, -1, 7, 8}));
    }
}
