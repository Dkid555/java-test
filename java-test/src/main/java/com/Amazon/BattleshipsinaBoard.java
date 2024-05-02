package com.Amazon;

public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int row = 0; row < board.length; ++row){
            for (int column = 0; column < board[row].length; ++column){
                if(board[row][column] != '.') {
                    countBattleships(board, row, column);
                    ++count;
                }
            }
        }
        return count;
    }

    private void countBattleships(char[][] board, int row, int column){
        if(row < 0 || row >= board.length || column < 0
                || column >= board[row].length || board[row][column] == '.')
            return;

        board[row][column] = '.';
        if(column + 1 < board[row].length && board[row][column + 1] != '.'){
            countBattleships(board, row, column + 1);
        }else if (row + 1 < board.length && board[row + 1][column] != '.'){
            countBattleships(board, row + 1, column);
        }
    }

}
//Given an m x n matrix board where each cell is a battleship
// 'X' or empty '.', return the number of the battleships on board.
//
//Battleships can only be placed horizontally or vertically on
// board. In other words, they can only be made of the shape 1 x k
// (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size.
// At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
//
//