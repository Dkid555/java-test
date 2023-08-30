package com.leet_easy;


//You are given an m x n matrix M initialized with all 0's and an array of operations ops,
// where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
//
//Count and return the number of maximum integers in the matrix after performing all the operations.
public class RangeAdditionII {
    public static int maxCount(int m, int n, int[][] ops) {
        int result = 0;
        if (ops.length == 0) return m * n;
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int[] coordinates : ops) {
            minA = Math.min(minA, coordinates[0]);
            minB = Math.min(minB, coordinates[1]);
        }
        return minA * minB;
    }

    public static void main(String[] args) {
        System.out.println(maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}
