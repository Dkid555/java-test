package com.leetcode;

public class StrictlyPalindromicNumber {
    private boolean isPal(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            StringBuilder s = new StringBuilder();
            int k = n;
            while (k > 0) {
                int r = k % i;
                s.append(r);
                k = k / i;
            }
            if (!isPal(s.toString()))
                return false;
        }
        return true;
    }

    public boolean isStrictlyPalindromic_best(int n) {
        return false;
    }
}
//An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive), the string representation of the integer n in base b is palindromic.
//
//Given an integer n, return true if n is strictly palindromic and false otherwise.
//
//A string is palindromic if it reads the same forward and backward.