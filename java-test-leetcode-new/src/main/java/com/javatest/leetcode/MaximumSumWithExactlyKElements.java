package com.javatest.leetcode;

import java.util.Arrays;

public class MaximumSumWithExactlyKElements {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // don't need to replace the element, just calc sum
        int result = max;
        for (int i = 1; i < k; i++) {
            result += ++max;
        }

        return result;
    }
}
