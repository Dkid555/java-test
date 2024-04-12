package com.Amazon.from_file.Arrrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums){
            sum += val;
            max = Math.max(max, sum);
            sum = Math.max(0, sum);
        }
        return max;
    }
}
