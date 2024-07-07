package com.javatest.leetcode;

import java.util.Arrays;

public class MaximumStrongPairXORI {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] - nums[i] <= nums[i]) {
                    res = Math.max(res, nums[i] ^ nums[j]);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
