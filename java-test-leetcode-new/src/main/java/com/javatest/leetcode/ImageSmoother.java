package com.javatest.leetcode;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int[] moves = new int[]{-1, 0, 1};

        int rows = img.length;
        int columns = img[0].length;

        int[][] res = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int count = 0;
                int value = 0;

                for (int a : moves) {
                    for (int b : moves) {
                        int x = row + a;
                        int y = column + b;

                        if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                        count++;
                        value += img[x][y];
                    }
                }
                res[row][column] = value / count;
            }
        }
        return res;
    }
}
