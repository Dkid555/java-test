package com.javatest.leet_easy;

public class WordExists {

    public static boolean exist(char[][] board, String word) {
//        String reverse = new StringBuilder(word).reverse().toString();


        for (int row = 0; row < board.length; ++row)
            for (int column = 0; column < board[0].length; ++column) {
                if ((board[row][column] == word.charAt(0)) && findWholeWord(board, word, row, column, 0, new
                        boolean[board.length][board[0].length])) return true;


//                if((board[row][column] == reverse.charAt(0)) && findWholeWord(board, reverse, row, column, 0, new
//                        boolean[board.length][board[0].length])) return true;
            }
        return false;
    }

    static boolean findWholeWord(char[][] board, String word, int row, int column, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (row >= board.length || row < 0 || column < 0
                || column >= board[0].length // visited filled with false by default allows to check if we have two same letters in a word
                || board[row][column] != word.charAt(index) || visited[row][column]) return false;

        visited[row][column] = true;
        boolean found = findWholeWord(board, word, row + 1, column, index + 1, visited) ||
                findWholeWord(board, word, row - 1, column, index + 1, visited) ||
                findWholeWord(board, word, row, column + 1, index + 1, visited) ||
                findWholeWord(board, word, row, column - 1, index + 1, visited);
        visited[row][column] = false;
        return found;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));

    }
}
