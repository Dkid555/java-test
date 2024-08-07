package com.javatest.leetcode;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n != 3 && (n & 3) == 3) {
                ++n;
            } else
                --n;
            count++;
        }
        return count;
    }
}
//Given a positive integer n, you can apply one of the following operations:
//
//If n is even, replace n with n / 2.
//If n is odd, replace n with either n + 1 or n - 1.
//Return the minimum number of operations needed for n to become 1.