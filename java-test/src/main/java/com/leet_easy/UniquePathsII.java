package com.leet_easy;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] deep = new int[obstacleGrid[0].length];
        deep[0] = 1;

        for (int row = 0; row < obstacleGrid.length; row++) {
            for (int column = 0; column < obstacleGrid[row].length; column++) {
                if (obstacleGrid[row][column] == 1) {
                    deep[column] = 0;
                } else {
                    if (column > 0) {
                        deep[column] += deep[column - 1];
                    }
                }
            }
        }

        return deep[obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {

    }

}
//You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
//
//Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The testcases are generated so that the answer will be less than or equal to 2 * 109.