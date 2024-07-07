package com.javatest.leetcode;


import java.math.BigInteger;

//Your task is to calculate ab mod 1337
// where a is a positive integer and b
// is an extremely large positive integer given in the form of an array.
public class SuperPow {
    public static int superPow(int a, int[] b) {
        String s = "";
        for (int x : b) {
            s += x;
        }
//        System.out.println(s);
        BigInteger integer = new BigInteger(s);
        int mod = 1337;
        int pow = 1;
        BigInteger zero = new BigInteger("0");

        while (!integer.equals(zero)) {
            if (!integer.mod(new BigInteger("2")).equals(zero)) {
                pow %= mod;
                pow *= a;
            }
            a %= mod;
            a *= a % mod;
            integer = integer.divide(BigInteger.TWO);
        }
        return pow % 1337;
    }

    //faster
    public static int superPow2(int a, int[] b) {
        long numberFromB = 0;

        //Euler theorem
        for (int i : b) {
            numberFromB = numberFromB * 10 + i;
            numberFromB = numberFromB % 1140;
        }
        int answer = 1;

        a = a % 1337;

        numberFromB = numberFromB % 1140;
        while (numberFromB > 0) {
            if (numberFromB % 2 == 1)
                answer = ((answer % 1337) * (a % 1337)) % 1337;
            a = ((a % 1337) * (a % 1337)) % 1337;
            numberFromB /= 2;
        }
        return answer % 1337;
    }

    public static int superPow3(int a, int[] b) {
        long numberFromB = 0;

        //Euler theorem
        for (int i : b) {
            numberFromB = numberFromB * 10 + i;
            numberFromB = numberFromB % 1140;
        }
        int answer = 1;

        a = a % 1337;

        while (numberFromB > 0) {
            if ((numberFromB & 1) != 0)
                answer = ((answer % 1337) * (a % 1337)) % 1337;
            a = ((a % 1337) * (a % 1337)) % 1337;
            numberFromB >>>= 1;
        }
        return answer % 1337;
    }

    public static void main(String[] args) {
        System.out.println(superPow3(2, new int[]{1, 0}));
    }
}
