package com.leet_easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int a = x ^ y;
        // System.out.println(a);
        String b = Integer.toBinaryString(a);
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') count++;
        }
        //System.out.println(b);
        return count;

    }

    //количетсво различных битов
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
//The Hamming distance between two integers is
// the number of positions at which the corresponding bits are different.
//
//Given two integers x and y, return the Hamming distance between them.