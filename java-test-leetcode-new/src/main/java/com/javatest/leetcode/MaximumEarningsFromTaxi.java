package com.javatest.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaximumEarningsFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));
        TreeMap<Integer, Long> dp = new TreeMap<>();
        dp.put(0, 0L);
        for (int[] ride : rides) {
            Long currProfit = dp.floorEntry(ride[0]).getValue() + (ride[1] - ride[0] + ride[2]);
            if (currProfit > dp.lastEntry().getValue()) {
                dp.put(ride[1], currProfit);
            }
        }
        return dp.lastEntry().getValue();
    }
}
//There are n points on a road you are driving your taxi on.
// The n points on the road are labeled from 1 to n in the
// direction you are going, and you want to drive from point 1
// to point n to make money by picking up passengers. You cannot change the direction of the taxi.
//
//The passengers are represented by a 0-indexed 2D integer array
// rides, where rides[i] = [starti, endi, tipi] denotes the ith
// passenger requesting a ride from point starti to point endi who is willing to give a tipi dollar tip.
//
//For each passenger i you pick up, you earn endi - starti + tipi dollars.
// You may only drive at most one passenger at a time.
//
//Given n and rides, return the maximum number of dollars you can earn by
// picking up the passengers optimally.
//
//Note: You may drop off a passenger and pick up a different passenger at the same point.