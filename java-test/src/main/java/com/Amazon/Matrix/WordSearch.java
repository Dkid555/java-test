package com.Amazon.Matrix;

import lombok.*;

import java.util.*;

public class WordSearch {

//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @EqualsAndHashCode
    private static class Letter{

        public Letter(Character letter, Map<Character, Set<Letter>> neighbors, int row, int column) {
            this.letter = letter;
            this.neighbors = neighbors;
            this.row = row;
            this.column = column;
        }

        public Character getLetter() {
            return letter;
        }

        public void setLetter(Character letter) {
            this.letter = letter;
        }

        public Map<Character, Set<Letter>> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(Map<Character, Set<Letter>> neighbors) {
            this.neighbors = neighbors;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        private Character letter;
        private Map<Character, Set<Letter>> neighbors;

        private int row;
        private int column;
    }
    public static boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length())
            return false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Map<String, Letter> map_of_form = new HashMap<>();
        Map<Character, Set<Letter>> map_to_start_search = new HashMap<>();
        for (int row = 0; row < board.length; ++row){
            for (int column = 0; column < board[row].length; ++column){
                Letter current;
                String current_position = row + "RC"+column;
                char current_char = board[row][column];
                if(map_of_form.containsKey(current_position)){
                    current = map_of_form.get(current_position);
                }else {
                    current = new Letter(current_char, new HashMap<>(), row, column);
                    map_of_form.put(current_position, current);
                    map_to_start_search.putIfAbsent(current_char, new HashSet<>());
                    map_to_start_search.get(current_char).add(current);
                } // соседи
                for(int[] direction : directions){
                    String position_neighbor = (row + direction[0]) + "RC" + (column + direction[1]);
                    Letter neighbor = null;
                    char neighbor_char = 0;
                    if(map_of_form.containsKey(position_neighbor)){
                        neighbor = map_of_form.get(position_neighbor);
                        neighbor_char = board[row + direction[0]][column + direction[1]];
                    }else { // если еще не задан
                        if(row + direction[0] < board.length && 0 <= row + direction[0] &&
                                column + direction[1] < board[row].length  && column + direction[1] >= 0){
                            neighbor_char = board[row + direction[0]][column + direction[1]];
                            neighbor = new Letter(neighbor_char, new HashMap<>(), row + direction[0],
                                    column + direction[1]);
                            map_of_form.put(position_neighbor, neighbor);
                            map_to_start_search.putIfAbsent(neighbor_char, new HashSet<>());
                            map_to_start_search.get(neighbor_char).add(neighbor);
                        }
                    }
                    if(neighbor != null && neighbor_char != 0){
                        current.getNeighbors().putIfAbsent(neighbor_char, new HashSet<>());
                        current.getNeighbors().get(neighbor_char).add(neighbor);
                    }
                }
            }
        }


        return BFS(map_to_start_search, 0, word, new Stack<>(), new HashSet<>(), null);
    }
    private  static boolean BFS (Map<Character, Set<Letter>> map_search, int i, String word,
                                 Stack<Integer> stack, Set<Letter> visited, Letter current_letter){
        if(visited.contains(current_letter))
            return false;
        visited.add(current_letter);

        if(i >= word.length()){
            stack.push(1);
            return true;
        }
        if(!stack.isEmpty())
            return true;
        char current = word.charAt(i);
        if(!map_search.containsKey(current)){
            return false;
        }
        for(Letter letter : map_search.get(current)){
            BFS(letter.getNeighbors(), i + 1, word, stack, visited, letter);
            visited.remove(letter);
        }
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B', 'C','E'},{'S','F', 'C', 'S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist_WORKS(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        boolean[][] visited = new boolean[rows][columns];
        boolean result = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result)
                        return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, String word, boolean[][] visited, int row, int column, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column] || board[row][column] != word.charAt(index)) {
            return false;
        }

        visited[row][column] = true;

        if (backtrack(board, word, visited, row + 1, column, index + 1) ||
                backtrack(board, word, visited, row - 1, column, index + 1) ||
                backtrack(board, word, visited, row, column + 1, index + 1) ||
                backtrack(board, word, visited, row, column - 1, index + 1)) {
            return true;
        }

        visited[row][column] = false;
        return false;
    }
}
