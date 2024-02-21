package com.leetcode;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minFallingPathSumOld(int[][] matrix) {
        int n = matrix.length;

        // Create a dp array to store minimum falling path sum
        int[][] dp = new int[n][n];

        // Copy the first row of the matrix to dp
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Iterate through each row of the matrix starting from the second row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate the minimum falling path sum for the current element
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE, j < n-1 ? dp[i-1][j+1] : Integer.MAX_VALUE));
            }
        }

        // Find the minimum falling path sum in the last row of dp
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n-1][j]);
        }

        return minSum;
    }


    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        if (m == 1 || n == 1) return A[0][0];

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        if (row == m - 1)
            return dp[row][col] = A[row][col];

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (col > 0)
            left = minFallingPathSum(A, row + 1, col - 1, dp);

        int straight = minFallingPathSum(A, row + 1, col, dp);

        if (col < n - 1)
            right = minFallingPathSum(A, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];

        return dp[row][col];
    }
}
