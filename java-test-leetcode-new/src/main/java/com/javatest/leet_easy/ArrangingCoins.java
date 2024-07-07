package com.javatest.leet_easy;

public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        if (n <= 1) return n;
        if (n <= 3) return n == 3 ? 2 : 1;
        long start = 2;
        long end = n / 2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long coinsFilled = mid * (mid + 1) / 2;
            if (coinsFilled == n) return (int) mid;
            if (coinsFilled < n) start = mid + 1;
            else end = mid - 1;
        }
        return (int) end;
    }

    //Here we need to find largest K that satisfies this equation K*(K+1)/2 <= N
    public static void main(String[] args) {
        System.out.println(arrangeCoins2(15));
    }


    public static int arrangeCoins2(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}

class Solution {
    public int arrangeCoins(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input Number is invalid. Only positive numbers are allowed");
        }
        return (int) (Math.sqrt(2 * n + 0.25) - 0.5);
    }
}