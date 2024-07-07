package com.Amazon.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
    public int totalNQueens(int n) {
        int[] result = {0};
        helper(result, new ArrayList<>(), new boolean[n * 2], new boolean[n * 2], new boolean[n], 0, n);
        return result[0];
    }
    private static void helper(int[] result, List<String> current_positions, boolean[] diagonal_left_down, boolean[] diagonal_right_down, boolean[] columns, int row, int num_of_Queens){
        if(row == num_of_Queens){
            ++result[0];
            return;
        }
        else {
            loop : for(int i = 0; i < num_of_Queens; ++i){
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
