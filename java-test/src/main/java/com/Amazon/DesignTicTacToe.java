package com.Amazon;

import java.util.HashMap;
import java.util.Map;

public class DesignTicTacToe {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(5);

        ticTacToe.move(2, 2, 1);
        ticTacToe.move(3, 3, 1);
        ticTacToe.move(4, 4, 1);
        ticTacToe.move(0, 0, 1);
        ticTacToe.move(1, 1, 1);

    }
    private static class TicTacToe {
        private int[] rows;
        private int[] columns;
        private int diag_left;
        private int diag_right;
        private int size;
        public TicTacToe(int n){
            rows = new int[n];
            columns = new int[n];
            diag_left = 0;
            diag_right = 0;
            size = n;
        }

        private int move(int row, int column, int player){
            int player_move = player == 1 ? 1 : -1;

            rows[row] += player_move;
            columns[column] += player_move;

            if(row == column)
                diag_left += player_move;
            if(row == size - column - 1)
                diag_right += player_move;

            if(size == Math.abs(rows[row]) || size == Math.abs(columns[column])
                    || size == diag_left || size == diag_right)
                return player;
            return 0;
        }
    }
}
//Design a Tic-tac-toe game that is played between two players on a n x n grid.
//
//You may assume the following rules:
//
//A move is guaranteed to be valid and is placed on an empty block.
//Once a winning condition is reached, no more moves is allowed.
//A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
