package com.javatest.leetcode;

public class MinimumOperationstoExceedThresholdValueI {
    public int minOperations(int[] nums, int k) {
        int num_of_operations = 0;
        for(int num : nums){
            if (num < k)
                ++num_of_operations;
        }
        return num_of_operations;
    }
}
