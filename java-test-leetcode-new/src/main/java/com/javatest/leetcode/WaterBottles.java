package com.javatest.leetcode;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int temp = 0;

        while (numExchange <= numBottles) {
            temp = numBottles % numExchange;
            numBottles = numBottles - temp;
            count += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + temp;
        }
        return count;
    }
}
