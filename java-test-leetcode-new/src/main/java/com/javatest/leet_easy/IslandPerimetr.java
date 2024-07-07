package com.javatest.leet_easy;

public class IslandPerimetr {

    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    count += 4;
                    count -= (column - 1 >= 0 && grid[row][column - 1] == 1) ? 1 : 0;
                    count -= (column + 1 != grid[row].length && grid[row][column + 1] == 1) ? 1 : 0;
                    count -= (row - 1 >= 0 && grid[row - 1][column] == 1) ? 1 : 0;
                    count -= (row + 1 != grid.length && grid[row + 1][column] == 1) ? 1 : 0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {1},
                {0}
        }));
    }

}
//You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
//
//Grid cells are connected horizontally/vertically (not diagonally).
// The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
//
//The island doesn't have "lakes", meaning the water inside isn't
// connected to the water around the island. One cell is a square with side length 1.
// The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
//
//