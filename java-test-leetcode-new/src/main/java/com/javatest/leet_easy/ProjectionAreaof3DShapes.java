package com.javatest.leet_easy;

public class ProjectionAreaof3DShapes {
    public static int projectionArea(int[][] grid) {
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            int top = 0, front = 0, side = 0;
            for (int col = 0; col < grid.length; col++) {
                if (grid[row][col] > 0) top++;
                front = Math.max(front, grid[row][col]);
                side = Math.max(side, grid[col][row]);
            }
            result += top + front + side;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][]{{1, 2}, {3, 4}}));
    }
}
