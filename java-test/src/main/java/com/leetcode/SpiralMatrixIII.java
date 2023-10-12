package com.leetcode;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int moves = 0;
        int[] rowColIndex = new int[]{rStart, cStart, 1}; // rowColIndex[2] - index
        result[0] = new int[]{rStart, cStart};
        while (rowColIndex[2] < result.length) {
            ++moves;
            addToResult(result, moves, 1, 0, rows, cols, rowColIndex);
            addToResult(result, moves, 0, 1, rows, cols, rowColIndex);
            ++moves;
            addToResult(result, moves, -1, 0, rows, cols, rowColIndex);
            addToResult(result, moves, 0, -1, rows, cols, rowColIndex);
        }
        return result;
    }

    private static void addToResult(int[][] result, int moves, int horizontal, int vertical, int rows, int cols, int[] rowColIndex) {
        for (int i = 0; i < moves; ++i) {
            rowColIndex[0] += vertical;
            rowColIndex[1] += horizontal;
            if (rowColIndex[0] < rows && rowColIndex[0] > -1 && rowColIndex[1] < cols && rowColIndex[1] > -1) {
                result[rowColIndex[2]] = new int[]{rowColIndex[0], rowColIndex[1]};
                ++rowColIndex[2];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(5, 6, 1, 4)));
    }
}
//You start at the cell (rStart, cStart) of an rows x cols grid facing east.
// The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
//
//You will walk in a clockwise spiral shape to visit every position in this grid.
// Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.).
// Eventually, we reach all rows * cols spaces of the grid.
//
//Return an array of coordinates representing the positions of the grid in the order you visited them.