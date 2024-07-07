package com.javatest.leetcode;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int answer = 0;
        int[][] helper = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; ++row) {
            if (matrix[row][0] == '1') {
                helper[row][0] = 1;
                answer = 1;
            }
        }
        for (int column = 0; column < matrix[0].length; ++column) {
            if (matrix[0][column] == '1') {
                helper[0][column] = 1;
                answer = 1;
            }
        }

        for (int row = 1; row < helper.length; ++row)
            for (int column = 1; column < helper[0].length; ++column) {
                if (matrix[row][column] == '1') {
                    helper[row][column] = 1 + Math.min(helper[row - 1][column - 1],
                            Math.min(helper[row][column - 1], helper[row - 1][column]));
                    answer = Math.max(helper[row][column], answer);
                }
            }
        return answer * answer;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.