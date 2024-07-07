package com.javatest.leet_easy;

public class SurfaceAreaof3DShapes {
    public static int surfaceArea(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] > 0)
                    res += 4 * grid[row][column] + 2;
                if (row > 0)
                    res -= Math.min(grid[row][column], grid[row - 1][column]) * 2;
                if (column > 0)
                    res -= Math.min(grid[row][column], grid[row][column - 1]) * 2;
            }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{{1, 2}, {3, 4}}));
    }
}
