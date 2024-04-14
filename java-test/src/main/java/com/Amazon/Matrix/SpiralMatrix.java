package com.Amazon.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static void row_column_traversal(int[][] matrix, int start_row_column, int k, int max_row, int max_column, List<Integer> result) {
        if (start_row_column > max_row || k > max_column)
            return;
        for (int j = start_row_column; j <= max_column; j++) {
            result.add(matrix[start_row_column][j]);
        }
        if (start_row_column != max_row) {
            for (int p = start_row_column + 1; p <= max_row; p++) {
                result.add(matrix[p][max_column]);

            }
        }
        if (k != max_column && start_row_column != max_row) {
            for (int j = max_column - 1; j >= k; j--) {
                result.add(matrix[max_row][j]);
            }
        }
        if (start_row_column != max_row && k != max_column) {
            for (int p = max_row - 1; p > start_row_column; p--) {
                result.add(matrix[p][k]);
            }
        }
        //recursion calling
        row_column_traversal(matrix, start_row_column + 1, k + 1, max_row - 1, max_column - 1, result);


    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        row_column_traversal(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralOrder(matrix));
    }
}

//Given an m x n matrix, return all elements of the matrix in spiral order.