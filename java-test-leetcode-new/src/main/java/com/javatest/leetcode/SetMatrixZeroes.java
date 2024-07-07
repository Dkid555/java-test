package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] rowsZeros = new int[rows];
        int[] colsZeros = new int[columns];

        for (int row = 0; row < rows; ++row)
            for (int column = 0; column < columns; ++column)
                if (matrix[row][column] == 0) {
                    rowsZeros[row] = 1;
                    colsZeros[column] = 1;
                }
        for (int row = 0; row < rows; ++row)
            for (int column = 0; column < columns; ++column)
                if (rowsZeros[row] == 1 || colsZeros[column] == 1)
                    matrix[row][column] = 0;


    }

    public void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int row = 0; row < rows; ++row)
            for (int column = 0; column < columns; ++column)
                if (matrix[row][column] == 0) {
                    map.put(row, column);
                }

        map.forEach((row, column) -> {
            int tempRow = 0;
            int tempCol = 0;
            while (tempCol < columns) {
                matrix[row][tempCol++] = 0;
            }
            while (tempRow < rows) {
                matrix[tempRow++][column] = 0;
            }
        });
    }
}
