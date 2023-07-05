package com.leetcode;

public class RangeSumQuery2DImmutable {

    public static void main(String[] args) {
        int[][] values = new int[][]{new int[]{3, 0, 1, 4, 2}
                , new int[]{5, 6, 3, 2, 1}
                , new int[]{1, 2, 0, 1, 5}
                , new int[]{4, 1, 0, 1, 7}
                , new int[]{1, 0, 3, 0, 5}};

        NumMatrix matrix = new NumMatrix(values);
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
    }
}


class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    //row1, col1 - upper left corner,/// row2,col2 - lower right corne

    //2, 1, 4, 3
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int c1 = col1;
        int r1 = row1;
        int sum = 0;
        while (true) {
            sum += matrix[r1][c1];
            c1++;
            if (c1 > col2) {
                c1 = col1;
                r1++;
            }
            if (r1 > row2)
                break;
        }
        return sum;

    }
}