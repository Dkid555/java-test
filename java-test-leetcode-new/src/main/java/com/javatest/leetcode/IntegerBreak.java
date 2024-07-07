package com.javatest.leetcode;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 4)
            return n - 1;
        int out = 1;
        while (n > 0) {
            if (n > 4) {
                n -= 3;
                out *= 3;
            } else if (n == 4) {
                out *= 4;
                break;
            } else if (n == 3) {
                out *= 3;
                break;
            } else {
                out *= 2;
                break;
            }
        }
        return out;
    }
}
