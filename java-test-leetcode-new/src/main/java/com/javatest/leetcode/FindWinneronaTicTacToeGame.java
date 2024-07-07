package com.javatest.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinneronaTicTacToeGame {
    public static String tictactoe(int[][] moves) {
        Map<String, Map<Integer, Integer>> filledGrid = new HashMap<>();

        for (int i = 0; i < moves.length; ++i) {
            List<String> positions = ((moves[i][0] == 1 && moves[i][1] == 1) ?
                    List.of(moves[i][0] + "R", moves[i][1] + "C", "DIAG", "RDIAG")
                    : (moves[i][0] == moves[i][1]) ? List.of(moves[i][0] + "R", moves[i][1] + "C", "DIAG")
                    : (((moves[i][0] + moves[i][1] == 2)) ? List.of(moves[i][0] + "R", moves[i][1] + "C", "RDIAG")
                    : List.of(moves[i][0] + "R", moves[i][1] + "C")));
            int AB = i % 2; // A -> 0, B -> 1
            for (String position : positions) {
                Map<Integer, Integer> fill = filledGrid.getOrDefault(position, new HashMap<>());
                fill.put(AB, fill.getOrDefault(AB, 0) + 1);
                if (fill.get(AB) == 3)
                    return i % 2 == 0 ? "A" : "B";
                filledGrid.put(position, fill);
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static String tictactoe2(int[][] moves) {
        int[] rows = new int[3];
        int[] columns = new int[3];
        int diag = 0;
        int rdiag = 0;
        int player = 1; // 1 - A // -1 - B
        for (int[] move : moves) {
            int row = move[0];
            int column = move[1];
            rows[row] += player;
            columns[column] += player;
            if (row == column)
                diag += player;
            if (row + column == 2)
                rdiag += player;
            if (Math.abs(rows[row]) == 3 || Math.abs(columns[column]) == 3 || Math.abs(diag) == 3 || Math.abs(rdiag) == 3)
                return player == 1 ? "A" : "B";
            player = -player;
        }
        return moves.length == 9 ? "Draw" : "Pending";

    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{
                {0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}
        };
        System.out.println(tictactoe(moves));

    }
}
//Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
//
//Players take turns placing characters into empty squares ' '.
//The first player A always places 'X' characters, while the second player B always places 'O' characters.
//'X' and 'O' characters are always placed into empty squares, never on filled ones.
//The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
//The game also ends if all squares are non-empty.
//No more moves can be played if the game is over.
//Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on
// grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw".
// If there are still movements to play return "Pending".
//
//You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.