package com.leet_easy;

public class Number1Bits {
    static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
//            if(n % 2 != 0) count++;
            if ((n & 1) == 1) count++;
//            System.out.println(Integer.toBinaryString(n));
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(286));
    }
}
