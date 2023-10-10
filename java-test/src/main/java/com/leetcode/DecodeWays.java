package com.leetcode;

public class DecodeWays {

    public static int numDecodings(String s) {
        int[] helper = new int[s.length()];
        if (s.charAt(0) - '0' == 0)
            return 0;
        for (int i = 0; i < helper.length; i++) {
            int a = s.charAt(i) - '0';
            if (a >= 1 && a <= 9)
                helper[i] += (i == 0) ? 1 : helper[i - 1];
            if (i == 0)
                continue;
            int b = s.charAt(i - 1) - '0';
            if (b * 10 + a >= 10 && b * 10 + a <= 26)
                helper[i] += (i == 1) ? 1 : helper[i - 2];
        }
        return helper[helper.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
//A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
//Given a string s containing only digits, return the number of ways to decode it.
//
//The test cases are generated so that the answer fits in a 32-bit integer.