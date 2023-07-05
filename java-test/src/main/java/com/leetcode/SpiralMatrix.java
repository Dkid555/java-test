package com.leetcode;


import java.util.ArrayList;
import java.util.List;

//Given an m x n matrix, return all elements of the matrix in spiral order.
public class SpiralMatrix {

    static void row(int[][] matrix, int i, int k, int n, int m, List<Integer> result) {
        if (i > n || k > m)
            return;
        for (int j = i; j <= m; j++) {
            result.add(matrix[i][j]);
        }
        if (i != n) {
            for (int p = i + 1; p <= n; p++) {
                result.add(matrix[p][m]);

            }
        }
        if (k != m && i != n) {
            for (int j = m - 1; j >= k; j--) {
                result.add(matrix[n][j]);
            }
        }
        if (i != n && k != m) {
            for (int p = n - 1; p > i; p--) {
                result.add(matrix[p][k]);
            }
        }
        //recursion calling
        row(matrix, i + 1, k + 1, n - 1, m - 1, result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        row(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
        return result;
    }


    public static void main(String[] args) {

        // first - row, sec - col
        int[][] mat = new int[2][3];

        System.out.println(spiralOrder(new
                int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));
    }
}
