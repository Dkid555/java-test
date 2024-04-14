package com.Amazon.Matrix;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows_Zeros = new HashSet<>();
        Set<Integer> cols_Zeros = new HashSet<>();

        for(int row = 0; row < matrix.length; ++ row){
            for (int column = 0; column < matrix[row].length; ++column){
                if(matrix[row][column] == 0){
                    rows_Zeros.add(row);
                    cols_Zeros.add(column);
                }
            }
        }
        for (int row : rows_Zeros){
            matrix[row] = new int[matrix[row].length];
        }
        for (int column : cols_Zeros){
            for (int row = 0; row < matrix.length; ++row){
                matrix[row][column] = 0;
            }
        }
    }
}
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//You must do it in place.