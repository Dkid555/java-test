package com.leetcode;

public class GameofLife {
    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int[][] result_board = new int[rows][columns];

        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                int neighbours_amount = 0;
                if (row != rows - 1) { // down
                    neighbours_amount += board[row + 1][column];
                    if (column > 0) { // down left
                        neighbours_amount += board[row + 1][column - 1];
                    }
                    if (column != columns - 1) { // down right
                        neighbours_amount += board[row + 1][column + 1];
                    }
                }
                if (column > 0) { // left
                    neighbours_amount += board[row][column - 1];
                }
                if (column != columns - 1) { // right
                    neighbours_amount += board[row][column + 1];
                }
                if (row > 0) {// up
                    neighbours_amount += board[row - 1][column];
                    if (column > 0) { // up left
                        neighbours_amount += board[row - 1][column - 1];
                    }
                    if (column != columns - 1) { // up right
                        neighbours_amount += board[row - 1][column + 1];
                    }
                }

                result_board[row][column] = board[row][column] == 1 ? (neighbours_amount < 2 || neighbours_amount > 3 ? 0
                        : 1) : (neighbours_amount == 3 ? 1 : 0);
            }
        }
        for (int row = 0; row < rows; row++) {
            board[row] = result_board[row].clone();                                                // copy all tempBoard elements back to board matrix
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }
}
