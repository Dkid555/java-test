package com.Amazon;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;

    }


}
//You are given an array prices where prices[i]
// is the price of a given stock on the ith day.
//
//Find the maximum profit you can achieve. You may complete as many
// transactions as you like (i.e., buy one and sell one share
// of the stock multiple times) with the following restrictions:
//
//After you sell your stock, you cannot
// buy stock on the next day (i.e., cooldown one day).
//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).