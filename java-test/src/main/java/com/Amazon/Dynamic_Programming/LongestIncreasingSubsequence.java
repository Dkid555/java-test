package com.Amazon.Dynamic_Programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) { // наша точка
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) { // идем до нашей точки
                    // если наша просматриваемая больше предыдущего значения (мы идем от начала к текущему)
                    // , то для текущего берем длину прошлого массива
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(0);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{2, 4, 5, 1, 5 , 6, 1 }));
    }
}
//Given an integer array nums, return the length of the longest strictly increasing subsequence.