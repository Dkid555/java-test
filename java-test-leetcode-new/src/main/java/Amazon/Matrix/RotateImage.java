package com.Amazon.Matrix;

import java.util.ArrayList;
import java.util.List;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length; // length of row or column;
        for(int row = 0; row < size; ++row){
            for (int column = row; column < size; ++column){
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }
        int left = 0;
        int right = size - 1;
        while (left < right){
            for (int row = 0; row < size; ++row){
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
            }
            ++left;
            --right;
        }

        //You are given an n x n 2D matrix representing an image,
        // rotate the image by 90 degrees (clockwise).
        //
        //You have to rotate the image in-place, which means you have
        // to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    }
}
