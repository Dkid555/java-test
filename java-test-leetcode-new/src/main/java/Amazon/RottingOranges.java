package com.Amazon;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1},
        };
        int[][] grid2 = {
                {1,0,2,1},
                {1,0,1,1},
                {1,1,1,1},
        };
        int[][] grid3 = {{0}};
        System.out.println(orangesRotting(grid2));
    }
    private static class Pair<L, R>{
        private L row;
        private R column;

        public Pair(L row, R column) {
            this.row = row;
            this.column = column;
        }
    }
    public static int orangesRotting(int[][] grid) {

        Set<Pair<Integer, Integer>> rotten_oranges = new HashSet<>();
        for (int row = 0; row < grid.length; ++row){
            for (int column = 0; column < grid[row].length; ++column){
                if(grid[row][column] == 2){
                    grid[row][column] = 1;
                    rotten_oranges.add(new Pair(row, column));
                }
            }

        }
        int minutes = 0;

        if(!rotten_oranges.isEmpty()){
            minutes = Math.max(rotten_orange(grid, rotten_oranges, 0, new HashMap<>()) - 1, 0);
        }

        for (int[] row : grid) {
            for (int orange : row) {
                if (orange == 1)
                    return -1;
            }
        }
        return minutes;
    }

    private static int rotten_orange(int[][] grid, Set<Pair<Integer, Integer>> rotten_oranges, int level,
                                     Map<Integer, Integer> level_poisoned){
        Set<Pair<Integer, Integer>> to_visit = new HashSet<>();
        for(Pair<Integer, Integer> pair : rotten_oranges){
            int row = pair.row;
            int column = pair.column;
            if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] != 1){
                continue;
            }
            to_visit.add(new Pair<>(row + 1, column));
            to_visit.add(new Pair<>(row - 1, column));
            to_visit.add(new Pair<>(row, column + 1));
            to_visit.add(new Pair<>(row, column - 1));

            grid[row][column] = 2;
            level_poisoned.put(level - 1, level_poisoned.getOrDefault(level - 1, 0) + 1);

        }
        if(!to_visit.isEmpty())
            rotten_orange(grid, to_visit, level + 1, level_poisoned);

        return level_poisoned.size();
    }
}
/**n
 * You are given an m x n grid where each cell can have
 * one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until
 * no cell has a fresh orange. If this is impossible, return -1.
 * */