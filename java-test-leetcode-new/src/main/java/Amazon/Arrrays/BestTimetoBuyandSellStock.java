package com.Amazon.Arrrays;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min_price = 2000000000;
        for (int price : prices) {
            if (min_price > price)
                min_price = price;
            else if (price - min_price > max) {
                max = price - min_price;
            }
        }
        return max;
    }
}

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy
// one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.