package com.javatest.leetcode;

public class NumberofProvinces {

    private static void helper(int[][] arr, int[] visited, int i) {
        for (int j = 0; j < arr.length; ++j) {
            if (arr[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1; // проходим до финального города (если i j отмечено, то и j i будет отмечено)
                helper(arr, visited, j);
            }
        }
    }

    public static int findCircleNum(int[][] arr) {
        // решение заключается в том, что мы буквально собираем провинции по маршруту прохода i->j->j1 и т.д. и отмечаем как пройденые в visited
        int n = arr.length;
        int[] visited = new int[n];
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) { // если заходим в новую провинцию
                ++result;
                helper(arr, visited, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        }));
    }
}
