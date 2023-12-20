package com.leetcode;

public class DivisibleandNondivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        int nonDivisible = 0;
        int divisible = 0;
        for (int i = 1; i <= n; ++i) {
            if (i % m == 0) divisible += i;
            else nonDivisible += i;
        }
        return nonDivisible - divisible;
    }
}
