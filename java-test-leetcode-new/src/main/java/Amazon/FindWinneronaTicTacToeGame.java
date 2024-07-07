package com.Amazon;

import java.util.HashMap;
import java.util.Map;

public class FindWinneronaTicTacToeGame {
    public String tictactoe(int[][] moves) {
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
}
