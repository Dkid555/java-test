package com.javatest.leet_easy;

public class GetMaximuminGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int result[] = new int[n + 1];
        int max = Integer.MIN_VALUE;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : result[i / 2] + result[i / 2 + 1];
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
//You are given an integer n. A 0-indexed integer array nums of length n + 1 is generated in the following way:
//
//nums[0] = 0
//nums[1] = 1
//nums[2 * i] = nums[i] when 2 <= 2 * i <= n
//nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
//Return the maximum integer in the array nums​​​.