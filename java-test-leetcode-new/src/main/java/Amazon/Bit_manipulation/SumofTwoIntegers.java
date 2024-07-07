package com.Amazon.Bit_manipulation;

public class SumofTwoIntegers {
    public static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 4));
    }
}
//Given two integers a and b, return the sum of the two integers without using the operators + and -.