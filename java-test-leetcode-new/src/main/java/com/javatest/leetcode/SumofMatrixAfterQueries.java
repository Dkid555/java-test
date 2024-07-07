package com.javatest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SumofMatrixAfterQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        for (int[] query : queries)
            fillMatrix(matrix, query[0], query[1], query[2]);
        long sum = 0;
        for (int row = 0; row < n; ++row)
            for (int column = 0; column < n; ++column)
                sum += matrix[row][column];
        return sum;
    }

    private void fillMatrix(int[][] matrix, int type, int index, int value) {
        if (type == 0) {
            for (int column = 0; column < matrix[index].length; ++column)
                matrix[index][column] = value;
        } else if (type == 1) {
            for (int row = 0; row < matrix.length; ++row)
                matrix[row][index] = value;
        }
    }

    public long matrixSumQueries2(int n, int[][] queries) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        long sum = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            long currSum;
            if (queries[i][0] == 0) {
                int row = queries[i][1];
                if (rows.contains(row))
                    continue;
                rows.add(queries[i][1]);
                int count = n - cols.size();
                currSum = (long) queries[i][2] * count;
            } else {
                int col = queries[i][1];
                if (cols.contains(col))
                    continue;

                cols.add(queries[i][1]);
                int count = n - rows.size();

                currSum = (long) queries[i][2] * count;
            }

            sum += currSum;
        }

        return sum;
    }
}
//You are given an integer n and a 0-indexed 2D array queries where queries[i] = [typei, indexi, vali].
//
//Initially, there is a 0-indexed n x n matrix filled with 0's. For each query,
// you must apply one of the following changes:
//
//if typei == 0, set the values in the row with indexi to vali, overwriting any previous values.
//if typei == 1, set the values in the column with indexi to vali, overwriting any previous values.
//Return the sum of integers in the matrix after all queries are applied.