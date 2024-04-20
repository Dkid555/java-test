package com.Amazon.Matrix;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberofIslands {
    public static int numIslands_old(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; ++row){
            for (int column = 0; column < grid[row].length; ++column){
                if(grid[row][column] == '1'){
                    boolean check_top = true;
                    boolean check_left = true;
                    if(row > 0 && grid[row - 1][column] == '1'){
                        check_top = false;
                    }
                    if(column > 0 && grid[row][column - 1] == '1'){
                        check_left = false;
                    }
                    if(check_left && check_top){
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    private static class Coordinate{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate that)) return false;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        private int row;
        private int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    private static class Island{

        Set<Coordinate> island;

        public Island(Set<Coordinate> island) {
            this.island = island;
        }
    }

    private static void addNewIsland(Set<Island> islands, Set<Coordinate> visited){
        Island island = new Island(new HashSet<>());
        island.island.addAll(visited);
        islands.add(island);
    }
    public static int numIslands(char[][] grid) {
        Set<Island> islands = new HashSet<>();

        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int row = 0; row < grid.length; ++row){
            for (int column = 0; column < grid[row].length; ++column){
                if(grid[row][column] == '1'){
                    if(islands.isEmpty()){
                        Set<Coordinate> visited = new HashSet<>();
                        visited.add(new Coordinate(row, column));
                        addNewIsland(islands, visited);
                        continue;
                    }
                    Set<Island> that_contain = new HashSet<>();
                    Set<Coordinate> visited = new HashSet<>();
                    visited.add(new Coordinate(row, column));
                    for(int[] move : moves){
                        int row_prev = row + move[0];
                        int col_prev = column + move[1];
                        if((row_prev >= 0 && row_prev < grid.length) && (col_prev >= 0 && col_prev < grid[row].length)
                                && grid[row_prev][col_prev] == '1'){

                            Coordinate coordinate_prev = new Coordinate(row_prev, col_prev);
                            visited.add(coordinate_prev);
                            for (Island island : islands){
                                if(island.island.contains(coordinate_prev))
                                    that_contain.add(island);
                            }
                        }
                    }
                    if(!that_contain.isEmpty()){
                        if(that_contain.size() > 1){
                            Island baseIsland = that_contain.iterator().next();
                            for (Island island : that_contain) {
                                baseIsland.island.addAll(island.island);
                            }
                            that_contain.remove(baseIsland);
                            for (Island island : that_contain) {
                                islands.remove(island);
                            }
                            baseIsland.island.addAll(visited);
                        }
                        else {
                            for (Island prev_island : that_contain){
                                prev_island.island.addAll(visited);
                            }
                        }
                    }
                    else {
                        addNewIsland(islands, visited);
                    }
                }
            }
        }
        return islands.size();
    }
    public int numIslands2(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        for(int row = 0; row < grid.length; row++){
            for (int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == '1') {
                    count++;
                    fillUpWithZeros(grid, row, column);
                }
            }
        }
        return count;
    }
    private void fillUpWithZeros(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != '1')
            return;
        grid[row][column] = '0';
        fillUpWithZeros(grid, row + 1, column);
        fillUpWithZeros(grid, row - 1, column);
        fillUpWithZeros(grid, row, column + 1);
        fillUpWithZeros(grid, row, column - 1);
    }
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}}));
    }
}
