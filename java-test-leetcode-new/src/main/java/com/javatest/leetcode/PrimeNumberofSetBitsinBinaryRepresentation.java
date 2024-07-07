package com.javatest.leetcode;

public class PrimeNumberofSetBitsinBinaryRepresentation {
    // Function to check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to count numbers with a prime number of set bits in the range [left, right]
    static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }
}
