package com.Amazon;

public class TilingaRectanglewiththeFewestSquares {
    public static void main(String[] args) {
        System.out.println(tilingRectangle(11, 13));
    }
    public static int tilingRectangle2(int n, int m) {
        int count = 1;
        while (n != m){
            if(n > m){
                n = n - m;
            }else{
                m = m - n;
            }
            ++count;
        }
        return count;
    }

    static int answer = Integer.MAX_VALUE;
    public static int tilingRectangle(int n, int m) {
        dfs(0, 0, new boolean[n][m], 0);
        return answer;
    }
    // (row, column) is the starting point for selecting a square
    // rect records the status of current rectangle
    // COUNT is the number of squares we have covered
    private static void dfs(int row, int column, boolean[][] rect, int COUNT) {
        int n = rect.length, m = rect[0].length;
        // optimization 1: The current COUNT >= the current answer
        if (COUNT >= answer) return;

        // Successfully cover the whole rectangle
        if (row >= n) {
            answer = COUNT;
            return;
        }

        // Successfully cover the area [0, ..., n][0, ..., column] => Move to next row
        if (column >= m) {
            dfs(row+1, 0, rect, COUNT);
            return;
        }

        // If (row, column) is already covered => move to next point (row, column+1)
        if (rect[row][column]) {
            dfs(row, column+1, rect, COUNT);
            return;
        }

        // Try all the possible size of squares starting from (row, column)
        for (int k = Math.min(n-row, m-column); k >= 1 && isAvailable(rect, row, column, k); k--) {
            cover(rect, row, column, k);
            dfs(row, column+1, rect, COUNT+1);
            uncover(rect, row, column, k);
        }
    }
    // Check if the area [r, ..., r+k][c, ..., c+k] is alreadc covered
    private static boolean isAvailable(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(rect[r+i][c+j]) return false;
            }
        }
        return true;
    }
    // Cover the area [row, ..., row+k][column, ..., column+k] with a k * k square
    private static void cover(boolean[][] rect, int row, int column, int k) {
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                rect[row+i][column+j] = true;
            }
        }
    }
    // Uncover the area [row, ..., row+k][column, ..., column+k]
    private static void uncover(boolean[][] rect, int row, int column, int k) {
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                rect[row+i][column+j] = false;
            }
        }
    }

}
