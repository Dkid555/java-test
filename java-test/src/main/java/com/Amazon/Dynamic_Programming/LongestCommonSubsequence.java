package com.Amazon.Dynamic_Programming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int text1_len = text1.length();
        int text2_len = text2.length();

        int[][] dp = new int[text1_len + 1][text2_len + 1];

        for (int i = 0; i <= text1_len; ++i) {
            for (int j = 0; j <= text2_len; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1_len][text2_len];
    }
}
//Given two strings text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.
//
//A subsequence of a string is a new string generated from the original
// string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.