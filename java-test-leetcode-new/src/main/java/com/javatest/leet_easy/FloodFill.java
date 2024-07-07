package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.LinkedList;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if (startColor == color) return image;
        LinkedList<Integer[]> line = new LinkedList<>();
        int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        line.add(new Integer[]{sr, sc});
        Integer[] tmp;
        while (line.size() > 0) {
            tmp = line.getFirst();
            line.removeFirst();
            for (int[] step : move) {
                if (tmp[0] + step[0] > -1 && tmp[0] + step[0] < image.length &&
                        tmp[1] + step[1] > -1 && tmp[1] + step[1] < image[0].length &&
                        image[tmp[0] + step[0]][tmp[1] + step[1]] == startColor) {
                    image[tmp[0] + step[0]][tmp[1] + step[1]] = color;

                    line.add(new Integer[]{tmp[0] + step[0], tmp[1] + step[1]});
                }
            }
        }
        return image;
    }

    public static int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        paintPixel(sr, sc, image.length, image[0].length, image, color, image[sr][sc]);
        return image;
    }

    static void paintPixel(int row, int column, int n, int m, int[][] image, int color, int currColor) {
        if (image[row][column] == currColor) {
            image[row][column] = color;
            if (isValidPixel(row + 1, column, n, m)) paintPixel(row + 1, column, n, m, image, color, currColor);
            if (isValidPixel(row, column + 1, n, m)) paintPixel(row, column + 1, n, m, image, color, currColor);
            if (isValidPixel(row - 1, column, n, m)) paintPixel(row - 1, column, n, m, image, color, currColor);
            if (isValidPixel(row, column - 1, n, m)) paintPixel(row, column - 1, n, m, image, color, currColor);
        }
    }

    static boolean isValidPixel(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(Arrays.deepToString(floodFill2(image, 1, 1, 2)));
    }
}
