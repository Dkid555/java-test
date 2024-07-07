package com.javatest.leetcode;


import java.util.*;

public class SorttheMatrixDiagonally {
    private static class CoordXY {
        int x;
        int y;

        public CoordXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] diagonalSort(int[][] mat) {

        Map<Integer, int[]> numbers = new HashMap<>();
        Map<Integer, Queue<CoordXY>> coordinates = new HashMap<>();

        for (int row = 0; row < mat.length; ++row) {
            for (int column = 0; column < mat[0].length; column++) {
                int key = row - column;
                int[] temp = numbers.getOrDefault(key, new int[101]);
                ++temp[mat[row][column]];
                numbers.put(key, temp);
                Queue<CoordXY> tempCoord = coordinates.getOrDefault(key, new ArrayDeque<>());
                tempCoord.add(new CoordXY(row, column));
                coordinates.put(key, tempCoord);
            }
        }
        for (Map.Entry<Integer, Queue<CoordXY>> entry : coordinates.entrySet()) {
            Queue<CoordXY> coordXYQueue = entry.getValue();
            int[] sortedBuck = numbers.get(entry.getKey());
            for (int i = 0; i < sortedBuck.length; ) {
                if (sortedBuck[i] > 0) {
                    --sortedBuck[i];
                    CoordXY coordXY = coordXYQueue.poll();
                    mat[coordXY.x][coordXY.y] = i;
                } else
                    ++i;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}
        };
        System.out.println(Arrays.deepToString(diagonalSort(mat)));
    }
}
