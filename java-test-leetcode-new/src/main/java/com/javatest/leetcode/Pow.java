package com.javatest.leetcode;


//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
public class Pow {
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1 || x == 0) return x;
        long p = n; //to long for logic of process
        if (p < 0) {
            p = Math.abs(p);
            x = 1 / x;
        }
        double pow = 1;
        while (p != 0) {

            //or n % 2 == 1
            if ((p & 1) != 0) pow *= x;
            x *= x;
            p >>>= 1;
        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.1, -2147483648));
    }
}
