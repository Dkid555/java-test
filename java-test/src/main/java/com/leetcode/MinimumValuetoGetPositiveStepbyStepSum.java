package com.leetcode;

public class MinimumValuetoGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int a : nums) {
            sum += a;
            min = Math.min(sum, min);
        }
        if (min < 0)
            return 1 + Math.abs(min);
        return 1;
    }
}
