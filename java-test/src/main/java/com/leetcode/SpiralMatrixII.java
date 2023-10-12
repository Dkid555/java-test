package com.leetcode;


import java.util.Arrays;
import java.util.stream.IntStream;

//Given a positive integer n, generate an n x n matrix
// filled with elements from 1 to n2 in spiral order.
public class SpiralMatrixII {
    //
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        int k = 1;
        while (top <= bottom && left <= right) {
            //right
            for (int i = left; i <= right; i++) {
                res[top][i] = k++;
            }
            top++;
            //bottom
            for (int i = top; i <= bottom; i++) {
                res[i][right] = k++;
            }
            right--;
            if (top <= bottom) {
                //left
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = k++;
                }
                bottom--;
            }
            if (left <= right) {
                //top
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = k++;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IntStream stream = Arrays.stream(generateMatrix(3)).flatMapToInt(Arrays::stream);
        stream.forEachOrdered(n -> System.out.print(n + " "));
    }
}
