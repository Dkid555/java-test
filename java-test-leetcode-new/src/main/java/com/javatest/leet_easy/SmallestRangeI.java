package com.javatest.leet_easy;

import java.util.Arrays;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int left = nums[0] + k;
        int right = nums[nums.length - 1] - k;
        int result = right - left;
        return Math.max(result, 0);
    }
}
