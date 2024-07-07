package com.Amazon;

import java.util.Stack;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
    }
    public static int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int idx = c - 'a';
            int max = Integer.MIN_VALUE;
            int left = Math.max((idx - k), 0);
            int right = Math.min((idx + k), 26);
            for (int j = left; j <= right; j++) {
                max = Math.max(max, dp[j]);
            }
            dp[idx] = max + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int ele : dp) {
            max = Math.max(ele, max);
        }
        return max;
    }
}
//You are given a string s consisting of lowercase
// letters and an integer k. We call a string t ideal if the following conditions are satisfied:
//
//t is a subsequence of the string s.
//The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
//Return the length of the longest ideal string.
//
//A subsequence is a string that can be derived from another
// string by deleting some or no characters without changing the order of the remaining characters.
//
//Note that the alphabet order is not cyclic. For example, the
// absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.