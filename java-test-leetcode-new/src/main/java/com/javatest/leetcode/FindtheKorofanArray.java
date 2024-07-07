package com.javatest.leetcode;

public class FindtheKorofanArray {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        int[] arr = new int[32];
        for (int j : nums) {
            int num = j;
            int index = 0;
            while (num != 0) {
                int dig = num % 2;
                num = num / 2;
                if (dig == 1) {
                    arr[index]++;
                }
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= k) {
                ans += (int) Math.pow(2, i);
            }
        }
        return ans;
    }

    public int findKOrBetter(int[] nums, int k) {
        int[] bits = new int[32];
        int res = 0;
        for (int num : nums) {
            for (int b = 0; num > 0; b++) {
                bits[b] += num % 2;
                num >>= 1;
                if (bits[b] == k) {
                    res |= 1 << b;
                }
            }
        }
        return res;
    }
}

//You are given a 0-indexed integer array nums, and an integer k.
//
//The K-or of nums is a non-negative integer that satisfies the following:
//
//The ith bit is set in the K-or if and only if there are at least k elements of nums in which bit i is set.
//Return the K-or of nums.
//
//Note that a bit i is set in x if (2i AND x) == 2i, where AND is the bitwise AND operator.
