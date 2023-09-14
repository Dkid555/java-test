package com.leet_easy;

import java.util.*;

public class SpecialPositionsinaBinaryMatrix {
    public static int numSpecial(int[][] mat) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Set<List<Integer>> coordinate = new HashSet<>();
        for (int row = 0; row < mat.length; row++)
            for (int column = 0; column < mat[row].length; column++) {
                Map<Integer, Integer> temp = map.getOrDefault(row + 1000, new HashMap<>());
                temp.put(mat[row][column], temp.getOrDefault(mat[row][column], 0) + 1);
                map.put(row + 1000, temp);
                temp = map.getOrDefault(column + 2000, new HashMap<>());
                temp.put(mat[row][column], temp.getOrDefault(mat[row][column], 0) + 1);
                map.put(column + 2000, temp);
                if (mat[row][column] == 1) {
                    coordinate.add(Arrays.asList(row + 1000, column + 2000));
                }
            }
        int count = 0;
        for (List<Integer> coord : coordinate) {
            if (map.get(coord.get(0)).getOrDefault(1, 0) == 1 && map.get(coord.get(1)).getOrDefault(1, 0) == 1)
                count++;

        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(mat));
    }

    public int numSpecial2(int[][] mat) {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        Set<List<String>> coordinate = new HashSet<>();
        for (int row = 0; row < mat.length; row++)
            for (int column = 0; column < mat[row].length; column++) {
                Map<Integer, Integer> temp = map.getOrDefault(row + "R", new HashMap<>());
                temp.put(mat[row][column], temp.getOrDefault(mat[row][column], 0) + 1);
                map.put(row + "R", temp);
                temp = map.getOrDefault(column + "C", new HashMap<>());
                temp.put(mat[row][column], temp.getOrDefault(mat[row][column], 0) + 1);
                map.put(column + "C", temp);
                if (mat[row][column] == 1) {
                    coordinate.add(Arrays.asList(row + "R", column + "C"));
                }
            }
        int count = 0;
        for (List<String> coord : coordinate) {
            if (map.get(coord.get(0)).getOrDefault(1, 0) == 1 && map.get(coord.get(1)).getOrDefault(1, 0) == 1)
                count++;

        }

        return count;
    }
}
//Given an m x n binary matrix mat, return the number of special positions in mat.
//
//A position (i, j) is called special if mat[i][j] == 1 and
// all other elements in row i and column j are 0 (rows and columns are 0-indexed).