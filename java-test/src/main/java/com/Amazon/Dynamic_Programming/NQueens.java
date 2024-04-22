package com.Amazon.Dynamic_Programming;

import lombok.AllArgsConstructor;

import java.util.*;

public class NQueens {
    @AllArgsConstructor
    private static class Coordinate{
        int row;
        int column;

    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        helper(result, new ArrayList<>(), new boolean[n * 2], new boolean[n * 2], new boolean[n], 0, n);

        return result;
    }

    private static void helper(List<List<String>> result, List<String> current_positions, boolean[] diagonal_left_down, boolean[] diagonal_right_down, boolean[] columns, int row, int num_of_Queens){
        if(row == num_of_Queens){
            result.add(new ArrayList<>(current_positions));
            return;
        }
        else {
            for(int i = 0; i < num_of_Queens; ++i){
                if(!columns[i] && !diagonal_left_down[row + i] && !diagonal_right_down[row + num_of_Queens - i]){
                    char[] current = new char[num_of_Queens];
                    Arrays.fill(current, '.');
                    current[i] = 'Q';
                    current_positions.add(new String(current));
                    columns[i] = true;
                    diagonal_left_down[row + i] = true;
                    diagonal_right_down[row + num_of_Queens - i] = true;

                    helper(result, current_positions, diagonal_left_down, diagonal_right_down,columns,
                            row + 1,num_of_Queens);
                    columns[i] = false;
                    diagonal_left_down[row + i] = false;
                    diagonal_right_down[row + num_of_Queens - i] = false;
                    current_positions.remove(current_positions.size() - 1);
                }
            }
        }
    }

}
