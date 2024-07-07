package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumResistance {
//    static int minimumResistence(List<List<Integer>> matrix){
//        int rows = matrix.size();
//        int columns = matrix.size();
//        Integer[][] dp = new Integer[rows][];
//        for (int i = 0; i < dp.length; i++)
//            dp[i] = new Integer[columns];
//        int ans = Integer.MAX_VALUE;
//        for (int row = 0; row < rows;
//             row += 1) {
//            ans = Math.min(ans, minpathSum( matrix, row, columns - 1, dp));
//        }
//        return ans;
//    }
//    static int minpathSum(List<List<Integer>> matrix, int row, int column, Integer[][] dp){
////        if()
//        if(column < 0)
//            return 0;
//        if(row < 0 || row >= matrix.size())
//            return Integer.MAX_VALUE;
//        if(dp[row][column] != null){
//            return dp[row][column];
//        }
//        int ans = matrix.get(row).get(column) + Math.min(minpathSum(matrix, row - 1, column +1, dp),
//                Math.min(minpathSum(matrix, row, column + 1, dp), minpathSum(matrix, row + 1, column + 1, dp)));
//        return dp[row][column] = ans;
//    }

    public static int minFallingPathSum(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int columns = matrix.size();
        int[][] dp = new int[rows][columns];
//        for (int i = 0; i < dp.length; i++)
//            dp[i] = new int[columns];
        int ans = Integer.MAX_VALUE;
        for (int row = rows - 1; row >= 0;
             row--) {
            ans = Math.min(ans, minPathSum(row, columns - 1, matrix, dp));
        }
        return ans;
    }

    private static int minPathSum(int row, int column,
                                  List<List<Integer>> matrix,
                                  int[][] dp) {
        if (column > 0) {
            return 0;
        }
        if (row < 0 || row >= matrix.size()) {
            return 100000000;
        }
        if (dp[row][column] != 0) {
            return dp[row][column];
        }
        int ans
                = matrix.get(row).get(column)
                + Math.min(
                minPathSum(row - 1, column - 1, matrix,
                        dp),
                Math.min(minPathSum(row, column - 1,
                                matrix, dp),
                        minPathSum(row + 1, column - 1,
                                matrix, dp)));
        return dp[row][column] = ans;
    }


    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        List<Integer> t3 = new ArrayList<>();
        Collections.addAll(t1, 2, 6, 7);
        Collections.addAll(t2, 1, 5, 8);
        Collections.addAll(t3, 3, 4, 9);
        matrix.add(t1);
        matrix.add(t2);
        matrix.add(t3);

        System.out.println(minFallingPathSum(matrix));
    }
}
