package com.javatest.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LuckyNumbersinaMatrix {

    private static class Position {
        String RowCol;
        int value;

        public Position() {
        }

        public Position(String RowCol, int value) {
            this.value = value;
            this.RowCol = RowCol;
        }

        public Position(int value) {
            this.value = value;
            this.RowCol = null;
        }

    }

    public static List<Integer> luckyNumbers(int[][] matrix) {

        Map<Integer, Position> smallestRow = new HashMap<>();

        Map<Integer, Position> biggestColumn = new HashMap<>();

        for (int row = 0; row < matrix.length; ++row) {
            if (!smallestRow.containsKey(row)) {
                smallestRow.put(row, new Position(Integer.MAX_VALUE));
            }
            for (int column = 0; column < matrix[row].length; ++column) {

                if (!biggestColumn.containsKey(column)) {
                    biggestColumn.put(column, new Position(Integer.MIN_VALUE));
                }
                if (biggestColumn.get(column).value < matrix[row][column]) {
                    biggestColumn.put(column, new Position(row + "RC" + column, matrix[row][column]));
                }
                if (smallestRow.get(row).value > matrix[row][column])
                    smallestRow.put(row, new Position(row + "RC" + column, matrix[row][column]));

            }
        }
        Set<String> smallest = smallestRow.values().stream().map(val -> val.RowCol).collect(Collectors.toSet());
        Set<String> biggest = biggestColumn.values().stream().map(val -> val.RowCol).collect(Collectors.toSet());

        smallest.retainAll(biggest);
        List<Integer> result = new ArrayList<>();
        if (!smallest.isEmpty()) {
            for (String RC : smallest
            ) {
                List<Integer> indexes = Arrays.stream(RC.split("RC")).map(Integer::parseInt).toList();
                result.add(matrix[indexes.get(0)][indexes.get(1)]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}}));
    }

}
//Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//
//A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.