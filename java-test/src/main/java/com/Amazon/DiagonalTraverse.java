package com.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverse {
    /**Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.*/

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }; //1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12

        int[][] mat2 = {
                {2,5,8},
                {4,0,-1}};//2, 5, 4, 0, 8, -1
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
        System.out.println(Arrays.toString(findDiagonalOrder(mat2)));
    }
    public static int[] findDiagonalOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();

        for(int row = 0; row < mat.length; ++row){
            diag(mat, row, 0, result, row % 2 == 0, result.size());
            if(row == mat.length - 1){
                for(int column = 1; column < mat[row].length; ++column)
                    diag(mat, row, column, result, (row + column) % 2 == 0, result.size());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void diag(int[][] mat, int row, int column, List<Integer> list, boolean switch_, int coord){
        if(row < 0 || row >= mat.length || column < 0 || column >= mat[row].length)
            return;
        if(switch_)
            list.add(mat[row][column]);
        else
            list.add(coord, mat[row][column]);
        diag(mat, row - 1, column + 1, list,switch_, coord);
    }
}
