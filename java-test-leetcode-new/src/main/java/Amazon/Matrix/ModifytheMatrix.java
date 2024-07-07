package com.Amazon.Matrix;

import java.util.ArrayList;
import java.util.List;

public class ModifytheMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] columns_max = new int[matrix[0].length];
        List<int[]> coordinates_1 = new ArrayList<>();

        for (int row = 0; row < matrix.length; ++row)
            for (int column = 0; column < matrix[row].length; ++column){
                if(matrix[row][column] == -1){
                    coordinates_1.add(new int[]{row, column});
                }
                else{
                    columns_max[column] = Math.max(columns_max[column], matrix[row][column]);
                }
            }

        for(int[] coordinate : coordinates_1){
            matrix[coordinate[0]][coordinate[1]] = columns_max[coordinate[1]];
        }
        return matrix;
    }
}
//Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix
// called answer. Make answer equal to matrix, then replace each element with the
// value -1 with the maximum element in its respective column.
//
//Return the matrix answer.