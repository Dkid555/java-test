package com.leetcode;

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
//Given two integers a and b, return the sum of the two integers without using the operators + and -.