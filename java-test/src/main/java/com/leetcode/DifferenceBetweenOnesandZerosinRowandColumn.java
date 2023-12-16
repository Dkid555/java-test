package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DifferenceBetweenOnesandZerosinRowandColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        String[] keys_column = {"OC", "ZC"}; // onesCol, zeroCol
        String[] keys_rows = {"OR", "ZR"}; // onesRow, zeroRow
        for (int row = 0; row < grid.length; ++row){
            for (int column = 0; column < grid[0].length; ++column){
                if(!map.containsKey(keys_column[0]+"_"+column)){
                    for (String key: keys_column
                         ) {
                        map.put(key + "_" + column, 0);
                    }
                }
                if(!map.containsKey(keys_rows[0]+"_"+row)){
                    for (String key: keys_rows
                    ) {
                        map.put(key + "_" + row, 0);
                    }
                }
                if(grid[row][column] == 1) {
                    map.put(keys_column[0]+"_"+column, map.get(keys_column[0]+"_"+column) + 1);
                    map.put(keys_rows[0]+"_"+row, map.get(keys_rows[0]+"_"+row) + 1);
                }else {
                    map.put(keys_column[1]+"_"+column, map.get(keys_column[1]+"_"+column) + 1);
                    map.put(keys_rows[1]+"_"+row, map.get(keys_rows[1]+"_"+row) + 1);
                }
            }
        }
        for (int row = 0; row < grid.length; ++row){
            for (int column = 0; column < grid[0].length; ++column){

                grid[row][column] = map.get(keys_rows[0] + "_" + row) + map.get(keys_column[0] + "_" + column) -
                        map.get(keys_rows[1] + "_" + row) - map.get(keys_column[1] + "_" + column);

            }
        }

        return grid;
    }

    public int[][] onesMinusZeros2(int[][] grid) {
        int rowLenght = grid.length;
        int colLenght = grid[0].length;
        int[] rowOnes = new int[rowLenght];
        int[] colOnes = new int[colLenght];
        for (int row = 0; row < rowLenght; ++row){
            for (int column = 0; column < colLenght; ++column){
                rowOnes[row] += grid[row][column];
                colOnes[column] += grid[row][column];
            }
        }
        for (int row = 0; row < rowLenght; ++row) {
            for (int column = 0; column < grid[0].length; ++column) {

                grid[row][column] = 2 * (rowOnes[row] + colOnes[column]) - rowLenght - colLenght;
            }
        }
        return grid;
    }


}
