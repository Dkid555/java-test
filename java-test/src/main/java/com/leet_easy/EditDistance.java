package com.leet_easy;

import java.util.Arrays;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        final int m = word1.length();//first word length
        final int n = word2.length();///second word length
        // dp[i][j] := min # of operations to convert word1[0..i) to word2[0..j)
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i)
            dp[i][0] = i;

        for (int j = 1; j <= n; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (word1.charAt(i - 1) == word2.charAt(j - 1))//same characters
                    dp[i][j] = dp[i - 1][j - 1];//no operation
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;                      //replace               //delete        //insert

        return dp[m][n];
    }

    //
    public static int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n + 1], cur = new int[n + 1];
        pre[0] = 0;
        for (int j = 1; j <= n; j++) pre[j] = j;
        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = pre[j - 1];
                } else {
                    cur[j] = Math.min(pre[j - 1], Math.min(cur[j - 1], pre[j])) + 1;
                }
            }
            pre = cur.clone();
            Arrays.fill(cur, 0);
        }
        return pre[n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "rose"));
    }
}
//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//You have the following three operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character