package com.leet_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') set.add(i + "_" + 0);
            if (board[i][column - 1] == 'O') set.add(i + "_" + (column - 1));
        }
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') set.add(0 + "_" + i);
            if (board[row - 1][i] == 'O') set.add((row - 1) + "_" + i);
        }
        for (String coord : set) {
            List<String> coordinates = Arrays.stream(coord.split("_")).toList();
            fillwithSharp(board, Integer.parseInt(coordinates.get(0)), Integer.parseInt(coordinates.get(1)));
        }

        for (int rows = 0; rows < board.length; rows++)
            for (int columns = 0; columns < board[0].length; columns++) {
                if (board[rows][columns] == 'O') board[rows][columns] = 'X';
                if (board[rows][columns] == '#') board[rows][columns] = 'O';
            }
    }

    // without Set // faster)
    public static void solve2(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') fillwithSharp(board, i, 0);
            if (board[i][column - 1] == 'O') fillwithSharp(board, i, column - 1);
        }
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') fillwithSharp(board, 0, i);
            if (board[row - 1][i] == 'O') fillwithSharp(board, row - 1, i);
        }
        for (int rows = 0; rows < board.length; rows++)
            for (int columns = 0; columns < board[0].length; columns++) {
                if (board[rows][columns] == 'O') board[rows][columns] = 'X';
                if (board[rows][columns] == '#') board[rows][columns] = 'O';
            }
    }

    private static void fillwithSharp(char[][] board, int row, int column) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || board[row][column] == 'X' || board[row][column] == '#') return;
        board[row][column] = '#';
        fillwithSharp(board, row + 1, column);
        fillwithSharp(board, row - 1, column);
        fillwithSharp(board, row, column + 1);
        fillwithSharp(board, row, column - 1);
    }


    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', '0', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        char[][] board2 = {{'O', 'O'}, {'O', 'O'}};

        solve2(board);
    }
}
