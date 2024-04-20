package com.Amazon.Arrrays;

public class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int[] stk = new int[arr.length + 1];
        int idx = 0;

        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        long res = dp[0];
        for (int i = 1; i < arr.length; i++) {
            while (idx >= 0 && arr[stk[idx]] >= arr[i]) {
                idx--; //popping stack top
            }

            dp[i] = idx < 0 ? arr[i] * (i + 1) : dp[stk[idx]] + (arr[i] * (i - stk[idx]));
            res += dp[i];
            stk[++idx] = i; //pushing into stack
        }

        return (int) (res % 1000000007);
    }
}
//Given an array of integers arr, find the sum of min(b), where b ranges over every
// (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.