package com.Amazon;

public class Minesweeper {
    char[][] board;
    int rowMax;
    int colMax;
    public char[][] updateBoard(char[][] board, int[] clicks) {
        this.board = board;
        this.rowMax = board.length;
        this.colMax = board[0].length;
        /* case 1: click on M, change to X, stop searching */
        if (this.board[clicks[0]][clicks[1]] == 'M') {
            this.board[clicks[0]][clicks[1]] = 'X';
            return this.board;
        }
        dfs(clicks[0], clicks[1]);

        return this.board;
    }

    private int checkMine(int row, int col) {
        int mine = 0;
        /* check surrounding cells */
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) // skip current cell
                    continue;
                int x = row + i, y = col + j;
                if (x < 0 || x >= rowMax || y < 0 || y >= colMax) //skip out board
                    continue;
                if (board[x][y] == 'M')
                    mine++;
            }
        }
        return mine;
    }

    private void dfs(int row, int col) {
        /* base case : out of board or current cell is B*/
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax || board[row][col] == 'B')
            return;
        /* case 1: click on E*/
        int numOfMine = checkMine(row, col);
        if (numOfMine > 0) {
            board[row][col] = (char)('0' + numOfMine);
            return;
        }
        /* case 2: no mines besides */
        board[row][col] = 'B';
        /* recursive call on surrounding cells */
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) // skip current cell
                    continue;
                dfs(row + i, col + j);
            }
        }
    }
}
//Let's play the minesweeper game (Wikipedia, online game)!
//
//You are given an m x n char matrix board representing the game board where:
//
//'M' represents an unrevealed mine,
//'E' represents an unrevealed empty square,
//'B' represents a revealed blank square that has no adjacent mines
// (i.e., above, below, left, right, and all 4 diagonals),
//digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
//'X' represents a revealed mine.
//You are also given an integer array click where click = [clickr, clickc]
// represents the next click position among all the unrevealed squares ('M' or 'E').
//
//Return the board after revealing this position according to the following rules:
//
//If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
//If an empty square 'E' with no adjacent mines is revealed, then change it to a
// revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square 'E' with at least one adjacent mine is revealed, then change
// it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.