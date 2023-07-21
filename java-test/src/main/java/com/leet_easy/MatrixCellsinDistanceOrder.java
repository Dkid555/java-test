package com.leet_easy;

import java.util.*;

public class MatrixCellsinDistanceOrder {

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        //Deque<List<Integer>> help = new ArrayDeque<>();
        Map<Integer, List<List<Integer>>> help = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                List<List<Integer>> temp = help.getOrDefault(Math.abs(rCenter - row) + Math.abs(cCenter - col), new ArrayList<>());
                temp.add(Arrays.asList(row, col));
                help.put(Math.abs(rCenter - row) + Math.abs(cCenter - col), temp);
            }
        }
        int index[] = new int[]{0};
        help.keySet().forEach(key -> {
            help.get(key).forEach(tuple -> {
                res[index[0]][0] = tuple.get(0);
                res[index[0]++][1] = tuple.get(1);
            });
        });
//         System.out.println(help.toString());
        return res;
    }

    public static int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[index][0] = row;
                result[index++][1] = col;
            }
        }
        Arrays.sort(result, Comparator.comparingInt(point -> Math.abs(point[0] - rCenter) + Math.abs(point[1] - cCenter)));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allCellsDistOrder2(2, 3, 1, 2)));
    }
}
