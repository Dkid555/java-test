package com.javatest.leetcode;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] answer = new int[mat.length][mat[0].length];

        for (int row = 0; row < mat.length; row++) {
            for (int column = 0; column < mat[0].length; column++) {
                int rowStart = Math.max(0, row - k),
                        rowEnd = Math.min(mat.length - 1, row + k),
                        colStart = Math.max(0, column - k),
                        colEnd = Math.min(mat[0].length - 1, column + k);
                answer[row][column] = blockSum(mat, rowStart, rowEnd, colStart, colEnd);
            }
        }

        return answer;
    }

    private int blockSum(int[][] mat, int rowStart, int rowEnd, int colStart, int colEnd) {
        int sum = 0;

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}
//Given a m x n matrix mat and an integer k, return a matrix answer
// where each answer[i][j] is the sum of all elements mat[r][c] for:
//
//i - k <= r <= i + k,
//j - k <= c <= j + k, and
//(r, c) is a valid position in the matrix.