package com.javatest.leet_easy;
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class BestTimeBuyandSellStock {
    static int maximizePr(int[] prices) {
        int max = 0;
        int min_price = 2000000000;
        for (int i = 0; i < prices.length; i++) {
            if (min_price > prices[i]) min_price = prices[i];
            else if (prices[i] - min_price > max) {
                max = prices[i] - min_price;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maximizePr(prices));

    }
}
