package com.leet_easy;

import java.util.*;

public class Matrix01 {
    public static int[][] updateMatrix(int[][] matrix) {
        Map<String, List<Integer>> mapZeros = new HashMap<>();
        Set<List<Integer>> coordinates = new HashSet<>();
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    mapZeros.put(row + "_" + column, Arrays.asList(row, column));
                } else
                    coordinates.add(Arrays.asList(row, column));
            }
        for (List<Integer> arr : coordinates) {
            int row = arr.get(0);
            int column = arr.get(1);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if (mapZeros.containsKey(row + "_" + i)) { // если column
                    min = Math.min(min, Math.abs(column - i));
                    if (min == 1)
                        break;
                }
                if (mapZeros.containsKey(i + "_" + column)) { // если column
                    min = Math.min(min, Math.abs(row - i));
                    if (min == 1)
                        break;
                }
            }
            matrix[arr.get(0)][arr.get(1)] = min;
        }
        return matrix;
    }

    public static int[][] updateMatrix2(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0][0];

        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int MAX_VALUE = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = MAX_VALUE;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1) {
                    queue.offer(new int[]{r, c});
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] matrix2 = {
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};

        System.out.println(Arrays.deepToString(updateMatrix(matrix2)));
    }

}
//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
//The distance between two adjacent cells is 1.