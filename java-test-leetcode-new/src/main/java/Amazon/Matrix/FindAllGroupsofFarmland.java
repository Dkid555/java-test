package com.Amazon.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindAllGroupsofFarmland {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}})));
    }
    public static int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        for (int row = 0; row < land.length; ++row){
            for (int column = 0; column < land[row].length; ++column){
                if(land[row][column] == 1){
                    Stack<int[]> min = new Stack<>();
                    Stack<int[]> max = new Stack<>();
                    recursive_fill_with_zeros(row, column, land, min, max);
                    if(!min.isEmpty() && !max.isEmpty()){
                        int[] min_ = min.pop();
                        int[] max_ = max.pop();
                        result.add(new int[]{min_[0], min_[1], max_[0], max_[1]});
                    }
                }
            }
        }
        return result.stream().toArray(int[][]::new);
    }


    private static void recursive_fill_with_zeros(int row, int column, int[][] land, Stack<int[]> min, Stack<int[]> max){
        if(row < 0 || row >= land.length || column < 0 || column >=land[row].length || land[row][column] == 0)
            return;
        land[row][column] = 0;
        if(min.isEmpty()){
            min.add(new int[]{row, column});
        }else {
            int[] temp = min.pop();
            temp[0] = Math.min(temp[0], row);
            temp[1] = Math.min(temp[1], column);
            min.add(temp);
        }

        if(max.isEmpty()){
            max.add(new int[]{row, column});
        }else {
            int[] temp = max.pop();
            temp[0] = Math.max(temp[0], row);
            temp[1] = Math.max(temp[1], column);
            max.add(temp);
        }

        recursive_fill_with_zeros(row - 1, column, land, min, max);
        recursive_fill_with_zeros(row + 1, column, land, min, max);
        recursive_fill_with_zeros(row, column - 1, land, min, max);
        recursive_fill_with_zeros(row, column + 1, land, min, max);

    }
}
