package com.leetcode;

public class SumofAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int size = (1 << n);
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    temp ^= nums[j];
                }
            }
            sum += temp;
        }
        return sum;
    }
}
