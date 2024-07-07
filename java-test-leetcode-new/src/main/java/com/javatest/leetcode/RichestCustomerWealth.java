package com.javatest.leetcode;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int total_on_acc = 0;
            for (int money : account)
                total_on_acc += money;
            max = Math.max(max, total_on_acc);
        }
        return max;
    }

    public int maximumWealth2(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int total_on_acc = Arrays.stream(account).sum();
            max = Math.max(max, total_on_acc);
        }
        return max;
    }
}
