package com.javatest.leet_easy;

/*The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).*/
public class FibonacciNumber {
    static int Fibonachi(int n) {
        if (n == 0 || n == 1) return n;
        int prev0 = 0, prev1 = 1, now = 0;
        for (int i = 2; i <= n; i++) {
            now = prev0 + prev1;
            prev0 = prev1;
            prev1 = now;
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(Fibonachi(19));
    }
}
