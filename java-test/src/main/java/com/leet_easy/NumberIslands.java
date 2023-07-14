package com.leet_easy;

public class NumberIslands {
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    count++;
                    fill(grid, row, column);
                }
            }
        }
        return count;
    }

    private static void fillUpWithZeros(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != '1') return;
        grid[row][column] = '0';
        fillUpWithZeros(grid, row + 1, column);
        fillUpWithZeros(grid, row - 1, column);
        fillUpWithZeros(grid, row, column + 1);
        fillUpWithZeros(grid, row, column - 1);
    }

    private static void fill(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != '1') return;
        grid[row][column] = '0';
        fill(grid, row - 1, column);
        fill(grid, row + 1, column);
        fill(grid, row, column + 1);
        fill(grid, row, column - 1);

    }


    public static void main(String[] args) {
        char[][] grid1 = new char[][]{new char[]
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = new char[][]{new char[]
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'}};
        char[][] grid3 = {{'1'}};
        System.out.println(numIslands(grid1));
    }
}


//Given an m x n 2D binary grid grid which represents
// a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting
// adjacent lands horizontally or vertically. You may assume
// all four edges of the grid are all surrounded by water.