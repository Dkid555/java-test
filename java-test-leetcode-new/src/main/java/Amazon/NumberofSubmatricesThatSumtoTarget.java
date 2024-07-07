package com.Amazon;

public class NumberofSubmatricesThatSumtoTarget {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length, result = 0;

        for (int l = 0; l < columns; ++l) {
            int[] sums = new int[105];
            for (int r = l; r < columns; ++r) {
                for (int i = 0; i < rows; ++i) {
                    sums[i] += matrix[i][r];
                }
                for (int i = 0; i < rows; ++i) {
                    int sum = 0;
                    for (int j = i; j < rows; ++j) {
                        sum += sums[j];
                        if (sum == target) {
                            ++result;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix= {{1,-1}, {-1,1}};
        System.out.println(numSubmatrixSumTarget(matrix, 0));
    }

}
