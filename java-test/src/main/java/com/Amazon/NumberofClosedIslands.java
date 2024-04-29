package com.Amazon;

import java.util.Stack;

public class NumberofClosedIslands {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        for(int row = 0; row < grid.length; ++ row){
            for(int column = 0; column < grid[row].length; ++column){
                if(grid[row][column] == 0){
                    Stack<Boolean> check = new Stack<>();
                    check.add(true);
                    fill_the_island(grid, row, column, check);
                    if(check.pop()){
                        ++count;
                    }}
            }
        }
        return count;
    }
    private static void fill_the_island(int[][] grid, int row, int column, Stack<Boolean> check){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length){
            while (!check.isEmpty())
                check.pop();
            check.add(false); // что тип остров дошел до границы, и не окружен
            return;
        }
        if(grid[row][column] == -1 || grid[row][column] == 1){// visited or water
            return;
        }

        grid[row][column] = -1;
        fill_the_island(grid, row + 1, column, check);
        fill_the_island(grid, row - 1, column, check);
        fill_the_island(grid, row, column + 1, check);
        fill_the_island(grid, row, column - 1, check);

    }

}
//Given a 2D grid consists of 0s (land) and 1s (water).
// An island is a maximal 4-directionally connected group
// of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//
//Return the number of closed islands.