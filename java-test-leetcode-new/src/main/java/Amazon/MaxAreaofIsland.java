package com.Amazon;

public class MaxAreaofIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; ++row){
            for (int column = 0; column < grid[row].length; ++column){
                if(grid[row][column] == 1){
                    max = Math.max(findMax(grid, row, column, new int[]{0})[0], max);
                }
            }
        }
        return max;
    }

    private static int[] findMax(int[][] grid, int row, int column, int[] max){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] != 1)
            return max;
        grid[row][column] = -1;
        ++max[0];
        findMax(grid, row + 1, column, max);
        findMax(grid, row - 1, column, max);
        findMax(grid, row, column + 1, max);
        findMax(grid, row, column - 1, max);
        return max;
    }
}
//You are given an m x n binary matrix grid. An island is a group of 1's
// (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
//
//The area of an island is the number of cells with a value 1 in the island.
//
//Return the maximum area of an island in grid. If there is no island, return 0.