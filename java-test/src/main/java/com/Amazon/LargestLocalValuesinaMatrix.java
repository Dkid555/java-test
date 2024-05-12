package com.Amazon;

public class LargestLocalValuesinaMatrix {
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] answer = new int[n - 2][n - 2];
        for (int row = 0; row < n - 2; ++row){
            for (int column = 0; column < n - 2; ++column){
                answer[row][column] = find3x3(grid, row + 1, column + 1);
            }
        }
        return answer;
    }
    private static int find3x3(int[][] grid, int row, int column){
        int max = Integer.MIN_VALUE;
        for (int current_row = row -1 ; current_row < row + 2; ++current_row){
            for (int current_column = column - 1; current_column < column + 2; ++column){
                max = Math.max(max, grid[current_row][current_column]);
            }
        }
        return max;
    }

}
/** You are given an n x n integer matrix grid.

 Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

 maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

 Return the generated matrix. */