package com.leetcode;

import java.util.List;
import java.util.Map;

public class LargestLocalValuesinaMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];
        List<List<Integer>> moves = List.of(
                List.of(0, 0),
                List.of(1, 0),
                List.of(-1, 0),
                List.of(0, 1),
                List.of(0, -1),
                List.of(1, 1),
                List.of(1, -1),
                List.of(-1, 1),
                List.of(-1, -1)
                );
        for (int row = 1; row < n - 1; row++)
            for(int column = 1; column < n - 1; column++)
                result[row - 1][column - 1] = findMax3x3(grid, row, column, moves);

        return result;
    }

    private int findMax3x3(int[][] grid, int row, int column, List<List<Integer>> moves){
        int max = Integer.MIN_VALUE;
        for (List<Integer> move : moves){
            max = Math.max(grid[row - move.get(0)][column - move.get(1)], max);
        }
        return max;
    }
}
//You are given an n x n integer matrix grid.
//
//Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
//
//maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
//In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
//
//Return the generated matrix.