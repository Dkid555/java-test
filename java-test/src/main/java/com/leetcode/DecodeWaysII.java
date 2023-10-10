package com.leetcode;

public class DecodeWaysII {
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        long previous = 1; // dp[i-2]
        long current = s.charAt(0) == '*' ? 9 : 1; // dp[i-1]
        for (int i = 1; i < s.length(); i++) {
            long sum = 0; // dp[i]
            char currentChar = s.charAt(i);
            char previousChar = s.charAt(i - 1);
            if (currentChar != '0') {
                sum = current * (currentChar == '*' ? 9 : 1);
            }
            if (previousChar == '*') {
                if (currentChar == '*') {
                    sum += previous * 15;
                } else if (currentChar <= '6') {
                    sum += previous * 2;
                } else {
                    sum += previous;
                }
            } else {
                if (currentChar == '*') {
                    if (previousChar == '1') {
                        sum += previous * 9;
                    } else if (previousChar == '2') {
                        sum += previous * 6;
                    }
                } else {
                    int num = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (num >= 10 && num <= 26) {
                        sum += previous;
                    }
                }
            }
            previous = current;
            current = sum % 1000000007;
        }

        return (int) current;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
