package com.leet_easy;

import java.util.Arrays;

public class ReshapetheMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        int oldRow = 0, oldCol = 0;
        int[][] res = new int[r][c];
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                res[row][col] = mat[oldRow][oldCol];
                oldCol++;
                if (oldCol == mat[0].length) {
                    oldRow++;
                    oldCol = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }
}
//In MATLAB, there is a handy function called reshape which can reshape
// an m x n matrix into a new one with a different size r x c keeping its original data.
//
//You are given an m x n matrix mat and two integers r and c representing
// the number of rows and the number of columns of the wanted reshaped matrix.
//
//The reshaped matrix should be filled with all the elements of the original
// matrix in the same row-traversing order as they were.
//
//If the reshape operation with given parameters is possible and legal, output
// the new reshaped matrix; Otherwise, output the original matrix.