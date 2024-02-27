package com.leetcode;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int column = -1;
        for (int row = 0; row < mat.length; ++row){
            ++column;
            sum += column != mat[0].length - 1 - column ?
                    (mat[row][column] + mat[row][mat[0].length - 1 - column]) : mat[row][column];
        }
        return sum;
    }
}
