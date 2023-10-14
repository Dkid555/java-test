package com.leetcode;

public class MinimumPathSum {

    //public int minPathSum(int[][] cost) {
    //        int m = cost.length;
    //        int n = cost[0].length;
    //        int[][] dp = new int[m][n];
    //        dp[0][0] = cost[0][0];
    //        for (int i = 1; i < m; i++) {
    //            dp[i][0] = dp[i - 1][0] + cost[i][0];
    //        }
    //        for (int i = 1; i < n; i++) {
    //            dp[0][i] = dp[0][i - 1] + cost[0][i];
    //        }
    //
    //        for (int i = 1; i < m; i++) {
    //            for (int j = 1; j < n; j++) {
    //                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
    //            }
    //        }
    //        return dp[m - 1][n - 1];
    //    }

    public static int minPathSum(int[][] grid) {
        return dps(grid, grid.length - 1, grid[0].length - 1);
    }

    private static int dps(int[][] grid, int row, int column) {
        if (row == 0 && column == 0) {
            return grid[row][column];
        } else if (row == 0) {
            return grid[row][column] + dps(grid, row, column - 1);
        } else if (column == 0) {
            return grid[row][column] + dps(grid, row - 1, column);
        }
        return grid[row][column] + Math.min(dps(grid, row - 1, column), dps(grid, row, column - 1));
    }

    //
    public static int minPathSum2(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return dps2(grid, grid.length - 1, grid[0].length - 1, memo);
    }

    private static int dps2(int[][] grid, int row, int column, int[][] memo) {
        if (row == 0 && column == 0) {
            return grid[row][column];
        } else if (row < 0 || column < 0) {
            return Integer.MAX_VALUE;
        } else if (memo[row][column] != 0) {
            return memo[row][column];
        } else {
            return memo[row][column] = grid[row][column] + Math.min(dps2(grid, row - 1, column, memo), dps2(grid, row, column - 1, memo));
        }
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum2(grid));
//        rec(new BigInteger("0"));
    }
//    public static int i = 0;
//    public static void rec(BigInteger i){
//        System.out.println(i);
//        rec(i.add(BigInteger.ONE));
//    }
}
//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.