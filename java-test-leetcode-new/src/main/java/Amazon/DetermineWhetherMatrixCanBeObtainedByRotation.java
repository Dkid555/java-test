package com.Amazon;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int count = 4;
        int n = mat.length;
        while (count > 0){
            if(isEqualMatrix(mat, target))
                return true;
            rotate(mat, n);
            --count;
        }
        return false;
    }
    private boolean isEqualMatrix(int[][] mat, int[][] target){
        for(int i = 0; i < mat.length; ++i){
            if(!Arrays.equals(mat[i], target[i]))
                return false;
        }
        return true;
    }
    private static void rotate(int[][] mat, int n){
        for (int row = 0; row < n; ++row){
            for (int col = row; col < n; ++col){
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }
        int left = 0;
        int right = n - 1;
        while(left < right){
            for (int[] row : mat){
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
            }
            ++left;
            --right;
        }
    }
}
//Given two n x n binary matrices mat and target, return true
// if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.