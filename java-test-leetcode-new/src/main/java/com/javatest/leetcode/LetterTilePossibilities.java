package com.javatest.leetcode;

import java.util.HashSet;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        int lenght = tiles.length();
        boolean[] visited = new boolean[lenght];
        helper("", set, visited, tiles, lenght);
        return set.size() - 1;
    }

    public static void helper(String str, HashSet<String> set, boolean[] visited, String tiles, int lenght) {
        set.add(str);
        for (int i = 0; i < lenght; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(str + tiles.charAt(i), set, visited, tiles, lenght);
                visited[i] = false;
            }
        }
    }
}
