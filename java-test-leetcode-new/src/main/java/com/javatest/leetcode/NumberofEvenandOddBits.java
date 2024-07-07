package com.javatest.leetcode;

import java.util.Arrays;


//You are given a positive integer n.
//
//Let even denote the number of even indices
// in the binary representation of n (0-indexed) with value 1.
//
//Let odd denote the number of odd indices
// in the binary representation of n (0-indexed) with value 1.
//
//Return an integer array answer where answer = [even, odd].
public class NumberofEvenandOddBits {

    public static int[] evenOddBit(int number) {
        int[] res = new int[2];
        char[] convertedNumber = Integer.toBinaryString(number).toCharArray();
        Count count = (chars, del) -> {
            int amount = 0;
            int index = 0;
            for (int i = chars.length - 1; i > -1; i--) {
                if (chars[i] == '1' && (index & 1) == del)
                    amount++;
                index++;
            }
            return amount;
        };
        res[0] = count.get(convertedNumber, 0);
        res[1] = count.get(convertedNumber, 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(17)));
    }
}

@FunctionalInterface
interface Count {
    int get(char[] arr, int del);
}
