package com.Amazon.Dynamic_Programming;

import java.util.Arrays;

public class OutofBoundaryPaths {
    int mod = 1000000007;

    public int findPaths(int rows, int cols, int maxMove, int startRow, int startColumn) {
        int[][][] matrix_3D = new int[rows][cols][maxMove + 1];

        for (int[][] matrix : matrix_3D)
            for (int[] line : matrix)
                Arrays.fill(line, -1);

        return findPaths(rows, cols, maxMove, startRow, startColumn, matrix_3D);
    }

    private int findPaths(int rows, int cols, int Moves, int currentRow, int currentCol, int[][][] matrix_3D){
        if(rows == currentRow || cols == currentCol || currentRow == -1 || currentCol == -1)
            return 1;
        if(Moves == 0)
            return 0;
        if(matrix_3D[currentRow][currentCol][Moves] >= 0)
            return matrix_3D[currentRow][currentCol][Moves];


        matrix_3D[currentRow][currentCol][Moves] =
                ((findPaths(rows, cols, Moves - 1, currentRow - 1, currentCol, matrix_3D)
                + findPaths(rows, cols, Moves - 1, currentRow + 1, currentCol, matrix_3D)) % mod
                +
                (findPaths(rows, cols, Moves - 1, currentRow, currentCol - 1, matrix_3D)
                + findPaths(rows, cols, Moves - 1, currentRow, currentCol + 1, matrix_3D)) % mod ) % mod;

        return matrix_3D[currentRow][currentCol][Moves];
    }

}

class main {
    public static void main(String[] args) {
        OutofBoundaryPaths outofBoundaryPaths = new OutofBoundaryPaths();
        //m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
        System.out.println(outofBoundaryPaths.findPaths(2, 2, 2, 0, 0));
    }
}
//There is an m x n grid with a ball. The ball
// is initially at the position [startRow, startColumn].
// You are allowed to move the ball to one of the four adjacent
// cells in the grid (possibly out of the grid crossing the grid boundary).
// You can apply at most maxMove moves to the ball.
//
//Given the five integers m, n, maxMove, startRow, startColumn, return
// the number of paths to move the ball out of the grid boundary.
// Since the answer can be very large, return it modulo 109 + 7.