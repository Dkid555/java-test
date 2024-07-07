package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();

        int cur = 1;
        // Build the squares array
        while (Math.pow(cur, 2) <= n) {
            squares.add((int) Math.pow(cur++, 2));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            // DP transition
            for (int j = 0; j < squares.size() && squares.get(j) <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - squares.get(j)]);
            }
        }
        return dp[n];
    }
}
//Given an integer n, return the least number of perfect square numbers that sum to n.
//
//A perfect square is an integer that is the square of an integer; in other words, it is
// the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
