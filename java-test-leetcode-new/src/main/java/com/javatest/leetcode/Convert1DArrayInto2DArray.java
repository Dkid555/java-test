package com.javatest.leetcode;

public class Convert1DArrayInto2DArray {

    public static int[][] construct2DArray(int[] original, int m, int n) {


        int[][] result = new int[m][n];
        if (m * n != original.length)
            return new int[0][0];
        int row = 0;
        int column = 0;
        for (int val : original
        ) {
            result[row][column] = val;
            column++;
            if (column == n) {
                column = 0;
                row++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(construct2DArray(new int[]{1, 2}, 1, 1));
    }
}
