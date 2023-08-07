package com.leet_easy;

//A perfect number is a positive integer that
// is equal to the sum of its positive divisors,
// excluding the number itself. A divisor of
// an integer x is an integer that can divide x evenly.
//
//Given an integer n, return true if n is a perfect number, otherwise return false.

public class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        int n = 1;
        int p = 2;
        while (n <= num) {
            int Meresen = (int) (Math.pow(2, p) - 1);
            if (isPrime(p) && isPrime(Meresen))
                n = (int) (Math.pow(2, p - 1) * Meresen);
            p++;
            if (num == n) return true;
        }
        return false;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;
        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(2096128));
    }
}
