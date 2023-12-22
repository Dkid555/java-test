package com.leetcode;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 5; i <= n; i *= 5)
            result += n / i;
        return result;
    }
}
//Given an integer n, return the number of trailing zeroes in n!.
//
//Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.