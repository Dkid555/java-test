package com.javatest.leetcode;

public class CheckIfArrayPairsAreDivisiblebyk {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            num %= k;
            if (num < 0) num += k;
            freq[num]++;
        }
        if (freq[0] % 2 != 0) return false;
        for (int i = 1; i <= k / 2; i++) // i - остаток
            if (freq[i] != freq[k - i])
                return false;

        return true;

    }
}
//Given an array of integers arr of even length n and an integer k.
//
//We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
//
//Return true If you can find a way to do that or false otherwise.

// a % k = x
// b % k = k - x;
// (a + b) % k = 0;