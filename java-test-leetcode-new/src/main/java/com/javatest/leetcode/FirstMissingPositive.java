package com.javatest.leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int[] helper = new int[nums.length + 1];
        for (int num : nums) {
            if (num >= 1 && num <= nums.length)
                ++helper[num];
        }
        for (int i = 1; i < helper.length; ++i) {
            if (helper[i] == 0)
                return i;
        }
        return helper.length;
    }
}
//Given an unsorted integer array nums, return the smallest missing positive integer.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.