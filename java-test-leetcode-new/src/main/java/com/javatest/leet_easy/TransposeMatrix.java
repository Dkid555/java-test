package com.javatest.leet_easy;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int[][] transponse = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++)
                transponse[column][row] = matrix[row][column];
        return transponse;
    }
}
//Given a 2D integer array matrix, return the transpose of matrix.
//
//The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.