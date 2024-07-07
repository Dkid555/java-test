package com.javatest.leet_easy;

import java.util.*;

public class AvailableCapturesforRook {
    public int numRookCaptures(char[][] board) {
        // row + 100
        // column + 1000
//        int indexRowRook = 0;
//        int indexColumnRook = 0;
        Map<Integer, List<Character>> positions = new HashMap<>();
        List<Integer> Rook = null;
        List<Integer> rowColumn = null;
        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 'p' || board[row][column] == 'B' || board[row][column] == 'R') {
                    if (board[row][column] == 'R') {
                        Rook = Arrays.asList(row, column);
                    }
                    List<Character> temp = positions.getOrDefault(row + 100, new ArrayList<>());
                    temp.add(board[row][column]);
                    positions.put(row + 100, temp);
                    temp = positions.getOrDefault(column + 1000, new ArrayList<>());
                    temp.add(board[row][column]);
                    positions.put(column + 1000, temp);
                    if (board[row][column] == 'R') {
                        rowColumn = Arrays.asList(positions.get(row + 100).size() - 1, positions.get(column + 1000).size() - 1);
                    }
                }
            }
        int result = 0;
        List<Character> Row = positions.get(Rook.get(0) + 100);
        List<Character> Column = positions.get(Rook.get(1) + 1000);
        int index = rowColumn.get(0) - 1;
        while (index >= 0) {
            if (Row.get(index--) == 'B')
                break;
            result++;
        }
        index = rowColumn.get(0) + 1;
        while (index < Row.size()) {
            if (Row.get(index++) == 'B')
                break;
            result++;
        }
        index = rowColumn.get(1) - 1;
        while (index >= 0) {
            if (Column.get(index--) == 'B')
                break;
            result++;
        }
        index = rowColumn.get(1) + 1;
        while (index < Column.size()) {
            if (Column.get(index++) == 'B')
                break;
            result++;
            break;
        }
        return result;
    }
}
