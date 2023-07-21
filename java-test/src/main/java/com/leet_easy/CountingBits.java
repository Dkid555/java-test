package com.leet_easy;

import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = bitCount(i); // or Integer.bitCount(i);
            // or ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int bitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}

//Given an integer n,
// return an array ans of length n + 1
// such that for each i (0 <= i <= n),
// ans[i] is the number of 1's in the binary representation of i.