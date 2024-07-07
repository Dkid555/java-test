package com.javatest.leetcode;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        for (int row = 1; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                if (matrix[row][column] == 1) {
                    matrix[row][column] = matrix[row - 1][column] + 1;
                }
            }
        }
        int result = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = columns - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                result = Math.max(result, s);
            }
        }
        return result;
    }
}
