package com.leetcode;

import java.util.Arrays;

public class ConcatenationofArray {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        int i = 0;
        for (int num : nums
        ) {
            result[i++] = num;
        }
        for (int num : nums
        ) {
            result[i++] = num;
        }
        return result;

    }

    public int[] getConcatenation2(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length * 2);
        System.arraycopy(nums, 0, result, nums.length, nums.length);
        return result;
    }
}
