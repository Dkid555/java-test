package com.leetcode;

public class SumofSquaresofSpecialElements {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 1; i <= n; ++i){
            if (n % i == 0)
                result += nums[i - 1] * nums[i - 1];
        }
        return result;
    }
}
//You are given a 1-indexed integer array nums of length n.
//
//An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.
//
//Return the sum of the squares of all special elements of nums.