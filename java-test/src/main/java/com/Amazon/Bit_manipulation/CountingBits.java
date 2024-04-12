package com.Amazon.Bit_manipulation;

public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for(int i = 0; i <= n; ++i){
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
//Given an integer n, return an array ans
// of length n + 1 such that for each i
// (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.