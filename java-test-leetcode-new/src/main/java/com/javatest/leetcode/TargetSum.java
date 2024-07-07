package com.javatest.leetcode;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, 0, target);
    }

    public int ways(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return ways(nums, index + 1, target - nums[index]) + ways(nums, index + 1, target + nums[index]);
    }
}
//You are given an integer array nums and an integer target.
//
//You want to build an expression out of nums by adding one
// of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.