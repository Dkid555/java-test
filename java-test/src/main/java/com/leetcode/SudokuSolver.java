package com.leetcode;

import java.util.*;


//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        Map<String, Set<Integer>> filled = new HashMap<>();
        Set<List<Integer>> emptyIndexes = new LinkedHashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Set<Integer> row = filled.getOrDefault("row " + i, new HashSet<>());
                Set<Integer> column = filled.getOrDefault("column " + j, new HashSet<>());
                Set<Integer> box = filled.getOrDefault("box " + i / 3 + "-" + j / 3, new HashSet<>());
                //we need to initialize set in map anyway, even if it's gonna be empty
                filled.put("row " + i, row);
                filled.put("column " + j, column);
                filled.put("box " + i / 3 + "-" + j / 3, box);

                if (board[i][j] == '.') {
                    //adding empty cells (row and column)
                    emptyIndexes.add(Arrays.asList(i, j));
                } else {
                    row.add(board[i][j] - '0');
                    column.add(board[i][j] - '0');
                    box.add(board[i][j] - '0');
                    filled.put("row " + i, row);
                    filled.put("column " + j, column);
                    filled.put("box " + i / 3 + "-" + j / 3, box);
                }
            }
        }

        checkvalidity(filled, emptyIndexes, board);

    }

    private static boolean checkvalidity(Map<String, Set<Integer>> filled, Set<List<Integer>> emptyIndexes,
                                         char[][] board) {
        for (List<Integer> indexes : emptyIndexes) {
            int row = indexes.get(0);
            int column = indexes.get(1);
            for (int number = 1; number <= 9; number++) {
                if (!filled.get("row " + row).contains(number) &&
                        !filled.get("column " + column).contains(number) &&
                        !filled.get("box " + row / 3 + "-" + column / 3).contains(number)) {
                    board[row][column] = (char) (number + '0');
                    filled.get("row " + row).add(number);
                    filled.get("column " + column).add(number);
                    filled.get("box " + row / 3 + "-" + column / 3).add(number);
                    emptyIndexes.remove(indexes);
                    if (checkvalidity(filled, emptyIndexes, board))
                        return true;
                    board[row][column] = '.';
                    filled.get("row " + row).remove(number);
                    filled.get("column " + column).remove(number);
                    filled.get("box " + row / 3 + "-" + column / 3).remove(number);
                }
            }
            emptyIndexes.add(indexes);
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        if (ValidSudoku.validSudoku_char(board1)) {
            solveSudoku(board1);
            for (char[] range : board1) {
                System.out.println(Arrays.toString(range));
            }
        } else System.out.println("Not valid Sudoku");

        System.out.println("========================================================================");

        char[][] board2 = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        if (ValidSudoku.validSudoku_char(board2)) {
            solveSudoku(board2);

            for (char[] range : board2) {
                System.out.println(Arrays.toString(range));
            }
        } else System.out.println("Not valid sudoku");

        System.out.println("=============================ExpertBoard=============================");

        char[][] boardExper = {
                {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '7', '2', '.', '3', '.', '.', '.', '5'},
                {'8', '.', '.', '.', '7', '.', '.', '.', '.'},
                {'9', '.', '7', '.', '1', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '8', '.', '.', '2'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '7'},
                {'.', '1', '.', '6', '.', '5', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '4', '.'},
                {'6', '5', '.', '8', '9', '.', '.', '.', '.'}
        };

        if (ValidSudoku.validSudoku_char(boardExper)) {
            solveSudoku(boardExper);
            Arrays.stream(boardExper).forEach(val -> System.out.println(Arrays.toString(val)));
        } else System.out.println("Not valid sudoku");
        System.out.println("=========================Madness======================================");


        char[][] madness = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        if (ValidSudoku.validSudoku_char(madness)) {
            solveSudoku(madness);
            Arrays.stream(madness).forEach(val -> System.out.println(Arrays.toString(val)));
        } else System.out.println("Not valid sudoku");

        System.out.println("=========================UnoNumber======================================");


        char[][] oneNumber = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        if (ValidSudoku.validSudoku_char(oneNumber)) {
            solveSudoku(oneNumber);
            Arrays.stream(oneNumber).forEach(val -> System.out.println(Arrays.toString(val)));
        } else System.out.println("Not valid sudoku");
    }
}

