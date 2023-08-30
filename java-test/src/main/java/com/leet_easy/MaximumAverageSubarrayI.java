package com.leet_easy;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int average = 0;
        for (int i = 0; i < k; i++) {
            average += nums[i];
        }
        double max = (double) average / k;
        for (int i = k; i < nums.length; i++) {
            average -= nums[i - k];
            average += nums[i];
            max = Math.max(max, (double) average / k);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
    }
}
//You are given an integer array nums consisting of n elements, and an integer k.
//
//Find a contiguous subarray whose length is equal to k that has
// the maximum average value and return this value. Any answer
// with a calculation error less than 10-5 will be accepted.