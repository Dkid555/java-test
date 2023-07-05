package com.leetcode;

import java.math.BigInteger;


// find Primes from 0 to n (that are less than n)

public class CountPrimes {
    public static int countPrimes(int n) {
        if (n <= 1) return 0;
        if (n <= 4) return n - 2;
        int count = 2;
        for (int i = 5; i < n; i++) {
            if (i % 2 == 0) continue;
            BigInteger integer = BigInteger.valueOf(i);
            if (integer.isProbablePrime((int) Math.log(i)))
                count += 1;
        }
        return count;
    }


    ///Sieve of Erathosthenes
    public static int countPrimes2(int n) {
        if (n <= 2) return 0;
        int result = 0;
        Boolean[] sieve = new Boolean[n];
        for (int i = 2; i < n; i++) {
            if (sieve[i] != null) continue;

            // Is if has not been tagged until now, then it is prime
            result++;

            int count = 2;

            // Keep filling the sieve until we run out of space
            while (i * count < n) {
                sieve[i * count] = true;
                count++;
            }
        }
        return result;
    }


    //
    public static int countPrimes3(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(countPrimes3(10000));
    }
}

class test {
    public static void main(String[] args) {
        BigInteger integer = BigInteger.valueOf(1769);
        System.out.println(integer.isProbablePrime((int) Math.log(1769)));
    }
}
