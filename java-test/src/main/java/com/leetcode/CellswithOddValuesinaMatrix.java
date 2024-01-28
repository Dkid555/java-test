package com.leetcode;

public class CellswithOddValuesinaMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] rc : indices) {
            rows[rc[0]]++;
            cols[rc[1]]++;
        }

        int oddRows = 0;
        for (int row : rows) {
            if (row % 2 == 1) {
                oddRows++;
            }
        }
        int oddCols = 0;
        for (int col : cols) {
            if (col % 2 == 1) {
                oddCols++;
            }
        }

        int odds = (oddRows * n) + (oddCols * m);
        int evensFromCrossOver = oddRows * oddCols;
        if (odds > 0 && oddRows > 0 && oddCols > 0) {
            odds = odds - (2 * evensFromCrossOver);
        }

        return odds;
    }
}
