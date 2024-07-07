package com.Amazon;

import java.util.Arrays;

public class DungeonGame {

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        int[][] dungeon2 = new int[][]{{3, 0, -3}, {-3, -2, -2}, {3, 1, -3}};

        int[][] dungeon3 = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};

        int[][] dungeon4 = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon4));
    }

    private static class Warrior {
        int min_health;

        public Warrior(int min_health) {
            this.min_health = min_health;
        }

    }

    public static int calculateMinimumHPc(int[][] dungeon) {
        int[] min_health = {Integer.MAX_VALUE};
        Warrior[][] dp = new Warrior[dungeon.length][dungeon[0].length];
        int start_health = dungeon[0][0] <= 0 ? Math.abs(dungeon[0][0]) + 1 : 1;
        recursiveSearch(dungeon, 0, 0, start_health, start_health, 0, min_health, dp);
        return dp[dungeon.length - 1][dungeon[dungeon.length - 1].length - 1].min_health;
    }

    private static void recursiveSearch(int[][] dungeon, int row, int column,
                                        int current_health, int minhealth, int count, int[] min_health,
                                        Warrior[][] dp) {
        if (row < 0 || row >= dungeon.length || column < 0 || column >= dungeon[row].length)
            return;
        if (current_health + dungeon[row][column] <= 0) {
            if (current_health < 1)
                ++count;
            minhealth += (Math.abs(current_health + dungeon[row][column]));
            current_health = 1;
        } else {
            current_health += dungeon[row][column];
        }


        if (dp[row][column] != null) {
            Warrior warrior_state = dp[row][column];
            if (warrior_state.min_health > Math.max(minhealth + count, 1)) {
                warrior_state.min_health = Math.max(minhealth + count, 1);
            } else {
                return;
            }
        }
        recursiveSearch(dungeon, row + 1, column, current_health, minhealth, count, min_health, dp);
        recursiveSearch(dungeon, row, column + 1, current_health, minhealth, count, min_health, dp);
        if (dp[row][column] == null)
            dp[row][column] = new Warrior(Math.max(minhealth + count, 1));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][] dp = new int[rows + 1][columns + 1];
        Arrays.fill(dp[rows], Integer.MAX_VALUE);
        dp[rows][columns - 1] = 1;
        for (int i = rows - 1; i >= 0; i--) {
            dp[i][columns] = Integer.MAX_VALUE;
            if (i == rows - 1) dp[i][columns] = 1;
            for (int j = columns - 1; j >= 0; j--) {
                int val = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(1, val);
            }
        }
        return dp[0][0];
    }

}
