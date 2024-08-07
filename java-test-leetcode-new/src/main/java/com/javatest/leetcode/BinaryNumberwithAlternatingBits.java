package com.javatest.leetcode;

public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int x = Character.compare(prev, s.charAt(i));
            System.out.println(x);
            if (x == 0) {
                return false;
            }
            prev = s.charAt(i);
        }
        return true;
    }
}
