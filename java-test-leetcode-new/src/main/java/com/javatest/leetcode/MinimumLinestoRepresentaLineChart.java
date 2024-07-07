package com.javatest.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumLinestoRepresentaLineChart {

    public static boolean checkIn(int[] point1, int[] point2, int[] pointCheck) {
        return (pointCheck[0] - point1[0]) * (point2[1] - point1[1]) == (point2[0] - point1[0]) * (pointCheck[1] - point1[1]);
    }

    public static int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1)
            return 0;
        else {
            Arrays.sort(stockPrices, (Comparator.comparingInt(o -> o[0])));
            int countLines = 1;
            for (int i = 1; i < stockPrices.length - 1; ++i) {
                if (!checkIn(stockPrices[i - 1], stockPrices[i], stockPrices[i + 1]))
                    ++countLines;
            }
            return countLines;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumLines(new int[][]{
                {1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}
        }));
    }
}
//You are given a 2D integer array stockPrices where stockPrices[i] = [dayi, pricei] indicates the price of the stock
// on day dayi is pricei. A line chart is created from the array by plotting the points on an XY plane with the X-axis
// representing the day and the Y-axis representing the price and connecting adjacent points.
// One such example is shown below:
//Input: stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
//        Output: 3