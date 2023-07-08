package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    //char[][]b = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}};


    //Adds the specified element to this set if it is not already present.
    // More formally, adds the specified element e to this set if this
    // set contains no element e2 such that Objects.equals(e, e2).
    // If this set already contains the element, the call leaves the set unchanged and returns false.
    //Params:
    //e – element to be added to this set
    //Returns:
    //true if this set did not already contain the specified element
    static boolean validSudoku(String[][] board) {
        //we have to create set of viewed values
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals(".")) {
                    // we check rows (0 - 8), columns (0 - 8) and one of the nine boxes
                    // 0-0, 0-1, 0-2
                    // 1-0, 1-1, 1-2
                    // 2-0, 2-1, 2-2
                    if (!seen.add("(" + board[i][j] + ")" + " in row " + i) ||
                            !seen.add("(" + board[i][j] + ")" + " in column " + j) ||
                            !seen.add("(" + board[i][j] + ")" + " in box " + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[][] board = {{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}, {"8", ".", ".", ".", "6", ".", ".", ".", "3"}, {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}, {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"}, {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        String[][] board1 = {{"8", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};


        char[][] ar = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        System.out.println(validSudoku(board));
        System.out.println(validSudoku(board1));
        System.out.println(validSudoku_char(ar));

    }


    static boolean validSudoku_char(char[][] board) {
        //we have to create set of viewed values
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    // we check rows (0 - 8), columns (0 - 8) and one of the nine boxes
                    // 0-0, 0-1, 0-2
                    // 1-0, 1-1, 1-2
                    // 2-0, 2-1, 2-2
                    if (!seen.add("(" + board[i][j] + ")" + " in row " + i) ||
                            !seen.add("(" + board[i][j] + ")" + " in column " + j) ||
                            !seen.add("(" + board[i][j] + ")" + " in box " + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }

}
