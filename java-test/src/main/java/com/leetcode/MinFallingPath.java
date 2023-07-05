package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinFallingPath {

    public static int minFallingPathI(List<List<Integer>> matrix) {
        int result = Integer.MAX_VALUE;
        int rows = matrix.size();
        int columns = matrix.get(0).size();
        int[][] temp = new int[rows][columns];
        for (int column = 0; column < columns; column++) {
            result = Math.min(result, helper(matrix, column, rows - 1, temp));
        }
        return result;
    }

    static int helper(List<List<Integer>> matrix, int column, int row, int[][] temp) {
        if (row < 0 || row == matrix.size()) return 0;
        if (column >= matrix.get(0).size() || column < 0) return Integer.MAX_VALUE;
        if (temp[row][column] != 0) return temp[row][column];
        int result = matrix.get(row).get(column) + Math.min(helper(matrix, column, row - 1, temp),
                Math.min(helper(matrix, column - 1, row - 1, temp), helper(matrix, column + 1, row - 1, temp)));
        return temp[row][column] = result;

    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        List<Integer> t3 = new ArrayList<>();
        Collections.addAll(t1, 2, 6, 7, 8);
        Collections.addAll(t2, 1, 5, 8, 9);
        Collections.addAll(t3, 3, 4, 9, 10);
        Collections.addAll(matrix, t1, t2, t3);

        System.out.println(matrix);

        System.out.println(minFallingPathI(matrix));
    }
}


//from left to right
// not working


class MinfromLefttoRight {
    public static int minLefttoRight(List<List<Integer>> matrix) {
        int result = Integer.MAX_VALUE;
        int rows = matrix.size();
        int columns = matrix.get(0).size();
        int[][] temp = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            result = Math.min(result, helper(matrix, columns - 1, row, temp));
        }
        return result;
    }

    static int helper(List<List<Integer>> matrix, int column, int row, int[][] temp) {
        if (column >= matrix.get(0).size() || column < 0) return 0;
        if (row == matrix.size() || row < 0) return Integer.MAX_VALUE;
        if (temp[row][column] != 0) return temp[row][column];
        int result = matrix.get(row).get(column) + Math.min(helper(matrix, column + 1, row - 1, temp),
                Math.min(helper(matrix, column + 1, row, temp), helper(matrix, column + 1, row + 1, temp)));
        return temp[row][column] = result;

    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        List<Integer> t3 = new ArrayList<>();
        Collections.addAll(t1, 2, 6, 7, 8);
        Collections.addAll(t2, 1, 5, 8, 9);
        Collections.addAll(t3, 3, 4, 9, 10);
        Collections.addAll(matrix, t1, t2, t3);

        System.out.println(matrix);

        System.out.println(minLefttoRight(matrix));
    }

}