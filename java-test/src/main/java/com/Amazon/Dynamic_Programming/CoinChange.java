package com.Amazon.Dynamic_Programming;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // индекс у dp это количество монет для заполнения
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int curr_coin = coin; curr_coin < dp.length; curr_coin++) {
                if (dp[curr_coin - coin] != Integer.MAX_VALUE) {
                    dp[curr_coin] = Math.min(dp[curr_coin], dp[curr_coin - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
