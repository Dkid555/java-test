package com.javatest.leetcode;

public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int n = s.length();
        int first = 0;
        int second = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') first++;
                else second++;
            } else {
                if (s.charAt(i) == '1') second++;
                else first++;
            }
        }
        return Math.min(first, second);
    }
}
