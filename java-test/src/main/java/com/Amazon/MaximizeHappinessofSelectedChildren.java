package com.Amazon;

import java.util.Arrays;
import java.util.Map;

public class MaximizeHappinessofSelectedChildren {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new
                int[]{1, 2, 3}, 2));
    }

    public static long maximumHappinessSum(int[] happines, int k) {
        long max_sum = 0;
        int pick = 0;
        Arrays.sort(happines);
        for (int i = happines.length - 1; i >= happines.length - k; i--) {
            max_sum += Math.max(0, happines[i] - pick++);
        }
        return max_sum;
    }
}
//You are given an array happiness of length n, and a positive integer k.
//
//There are n children standing in a queue, where the ith child
// has happiness value happiness[i]. You want to select k children from these n children in k turns.
//
//In each turn, when you select a child, the happiness value of all
// the children that have not been selected till now decreases by 1.
// Note that the happiness value cannot become negative and gets decremented only if it is positive.
//
//Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.