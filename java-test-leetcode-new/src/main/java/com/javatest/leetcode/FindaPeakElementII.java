package com.javatest.leetcode;

public class FindaPeakElementII {
    public int getMaxElement(int[][] matrix, int mid) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            int currentElement = matrix[row][mid];
            if (currentElement > max) {
                max = currentElement;
                index = row;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] matrix) {
        int columns = matrix[0].length;

        int start = 0;
        int end = columns - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = getMaxElement(matrix, mid);
            int left = -1;
            int right = -1;

            if (mid - 1 >= 0) {
                left = matrix[row][mid - 1];
            }

            if (mid + 1 < columns) {
                right = matrix[row][mid + 1];
            }

            if (matrix[row][mid] > left && matrix[row][mid] > right) {
                return new int[]{row, mid};
            } else if (matrix[row][mid] > right) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
