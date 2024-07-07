package com.javatest.leetcode;

public class FillingBookcaseShelves {
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int[] memo = new int[books.length + 1];

        for (int index = books.length - 1; index >= 0; index--) {
            int ans = Integer.MAX_VALUE;
            int height = 0;
            int width = 0;

            for (int i = index; i < books.length; i++) {
                width += books[i][0];

                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[i][1]);
                ans = Math.min(ans, height + memo[i + 1]);
            }
            memo[index] = ans;
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int[][] books = new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        System.out.println(minHeightShelves(books, 4));
    }
}
