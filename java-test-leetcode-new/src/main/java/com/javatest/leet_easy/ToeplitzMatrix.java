package com.javatest.leet_easy;

//Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
//
//A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int column = 0; column < matrix[row].length - 1; column++) {
                if (row + 1 < matrix.length && column + 1 < matrix[row].length) {
                    if (matrix[row][column] != matrix[row + 1][column + 1])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }
}
