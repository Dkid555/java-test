package com.javatest.leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m) {
                    dp[i][j] = ((j == n) || (p.charAt(j) == '*' && dp[i][j + 1]));
                } else if (j == n) {
                    dp[i][j] = false;
                } else {
                    if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (p.charAt(j) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

}
