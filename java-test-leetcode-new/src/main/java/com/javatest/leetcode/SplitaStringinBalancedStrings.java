package com.javatest.leetcode;

public class SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        int count = 0;
        int R = 0;
        int L = 0;
        for (int a = 0; a < s.length(); a++) {
            if (s.charAt(a) == 'R') {
                R++;
            } else {
                L++;
            }
            if (R == L) {
                count++;
                R = 0;
                L = 0;
            }
        }
        return count;
    }
}
