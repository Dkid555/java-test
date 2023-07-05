package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {


    //You have chess board nxn, place n-Queens that no one won't be able to eat each other

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] row : board
        ) {
            Arrays.fill(row, '.');
        }
        helper(board, 0, 0, n, result);
        return result;
    }

    private static void helper(char[][] board, int row, int column, int n, List<List<String>> result) {
        // column out bound
        if (column == board[0].length) {
            column = 0;
            row++;
        }
        // n is 0 then add to the result
        if (n == 0) {
            List<String> solution = new ArrayList<>();
            for (char[] line : board) {
                solution.add(String.valueOf(line));
            }
            result.add(solution);
            return;
        }
        //Row out of Bound
        if (row == board.length) {
            return;
        }
        //Place Queen here
        if (isValid2(board, row, column)) {
            board[row][column] = 'Q';
            n--;
            // after added Q go to the next column
            helper(board, row, column + 1, n, result);
            // backtrack unchoose the option
            board[row][column] = '.';
            n++;
        }

        // Skip this cell, we place a '.'
        helper(board, row, column + 1, n, result);
    }


    private static boolean isValid(char[][] board, int row, int col) {
        int N = board.length;
        // LEFT/Right AND DOWN/UP
        for (int i = 0; i < N; i++) {
            if (board[i][col] != '.')
                return false;
            if (board[row][i] != '.')
                return false;
        }
        // Top left + top right + down left + down right
        int i = row, j = col;
        // Top left
        while (0 <= i && 0 <= j) {
            if (board[i][j] != '.')
                return false;
            i--;
            j--;
        }
        // Top right
        i = row;
        j = col;
        while (0 <= i && j < N) {
            if (board[i][j] != '.')
                return false;
            i--;
            j++;
        }
        // Down Right
        i = row;
        j = col;
        while (i < N && j < N) {
            if (board[i][j] != '.')
                return false;
            i++;
            j++;
        }
        // Down left
        i = row;
        j = col;
        while (i < N && 0 <= j) {
            if (board[i][j] != '.')
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static boolean isValid2(char[][] board, int row, int column) {
        //check up/down and left/right;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != '.')
                return false;
            if (board[row][i] != '.')
                return false;
        }
        // Top left + top right + down left + down right
        int i = row, j = column;
        // Top left
        while (0 <= i && 0 <= j) {
            if (board[i][j] != '.')
                return false;
            i--;
            j--;
        }
        // Top right
        i = row;
        j = column;
        while (0 <= i && j < board.length) {
            if (board[i][j] != '.')
                return false;
            i--;
            j++;
        }
        // Down Right
        i = row;
        j = column;
        while (i < board.length && j < board.length) {
            if (board[i][j] != '.')
                return false;
            i++;
            j++;
        }
        // Down left
        i = row;
        j = column;
        while (i < board.length && 0 <= j) {
            if (board[i][j] != '.')
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
