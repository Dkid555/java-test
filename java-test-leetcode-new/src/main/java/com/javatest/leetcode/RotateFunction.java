package com.javatest.leetcode;

public class RotateFunction {
    public static int maxRotateFunction(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max += i * nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, shiftAndCount(nums));
        }
        return max;
    }

    private static int shiftAndCount(int[] nums) {
        int result = 0;
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; --i) {
            nums[i] = nums[i - 1];
            result += nums[i] * i;
        }
        nums[0] = last;
        return result;
    }

    public int maxRotateFunction2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int functionValue = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            functionValue += i * nums[i];
        }
        int maxFunctionValue = functionValue;
        for (int i = n - 1; i >= 1; i--) {
            functionValue = functionValue + sum - n * nums[i];
            maxFunctionValue = Math.max(maxFunctionValue, functionValue);
        }

        return maxFunctionValue;
    }

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{100}));
    }

}


//You are given an integer array nums of length n.
//
//Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:
//
//F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
//Return the maximum value of F(0), F(1), ..., F(n-1).
//
//The test cases are generated so that the answer fits in a 32-bit integer.
//
//
//
//Example 1:
//
//Input: nums = [4,3,2,6]
//Output: 26
//Explanation:
//F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
//F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
//F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
//F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
//So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.