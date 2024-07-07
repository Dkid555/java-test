package com.Amazon.Dynamic_Programming;

import java.util.Arrays;

public class NumberofDiceRollsWithTargetSum {


//    public int isSafe(int n, int k, int target, int[][] matrix) {
//
//        if (n < 0 || target < 0) return 0;
//        if (n == 0 && target == 0) return 1;
//        if (matrix[n][target] >= 0) return matrix[n][target];
//
//        int ans = 0;
//
//        for (int i = 1; i <= k; i++) {
//            if (i <= target) {
//                ans = (ans + isSafe(n - 1, k, target - i, matrix)) % 1000000007;
//            }
//        }
//        matrix[n][target] = ans;
//        return ans;
//    }
//
//    public int numRollsToTarget(int n, int k, int target) {
//
//        int[][] matrix = new int[n + 1][target + 1];
//
//        for (int[] row : matrix) {
//            Arrays.fill(row, -1);
//        }
//
//        return isSafe(n, k, target, matrix);
//    }
    // n - количество кубиков
    // k - стороны у кубика
    // target - цель
    private static int mod = 1000000007;
    private static int find_possible(int n, int k, int target, int[][] matrix){
        if(n < 0 || target < 0){
            return 0;
        }
        if(n == 0 && target == 0)
            return 1;

        if(matrix[n][target] >= 0)
            return matrix[n][target];

        int answer = 0;

        for(int side = 1; side <= k; ++side){
            if(side <= target){
                answer = (answer + find_possible(n - 1, k, target - side, matrix)) % mod;
            }
        }

        matrix[n][target] = answer;

        return answer;
    }
    public static int numRollsToTarget(int n, int k, int target) {
        int[][] matrix = new int[n + 1][target + 1];

        for (int[] row : matrix){
            Arrays.fill(row, -1);
        }
        return find_possible(n, k, target, matrix);
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
    }
}
//You have n dice, and each dice has k faces numbered from 1 to k.
//
//Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice,
// so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.