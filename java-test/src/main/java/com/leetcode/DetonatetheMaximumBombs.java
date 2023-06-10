package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DetonatetheMaximumBombs {
    static int find(int[][] bombs) {
        Map<Integer, Integer> b = new HashMap<>();
        for (int i = 1; i < bombs.length; i++) {
            double len = Math.sqrt(Math.pow(bombs[i][0] - bombs[i - 1][0], 2) + Math.pow(bombs[i][0] - bombs[i - 1][0], 2));

        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] bombs = new int[][]{{2, 1, 3}, {6, 1, 4}};

    }

}
