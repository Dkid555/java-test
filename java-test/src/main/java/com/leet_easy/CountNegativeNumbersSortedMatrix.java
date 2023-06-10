package com.leet_easy;

// count all negative numbers in sorted matrix;
public class CountNegativeNumbersSortedMatrix {
    static int countNegatives(int[][] grid) {
        int sum = 0;
        int j = 0;
        int i = grid[0].length - 1;

        while (i >= 0 && j < grid.length) {
            if (grid[j][i] < 0) {
                sum += grid.length - j;
                i--;
            } else j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegatives(grid));
    }
}
