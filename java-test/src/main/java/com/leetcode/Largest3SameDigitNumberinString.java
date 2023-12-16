package com.leetcode;

public class Largest3SameDigitNumberinString {
    public String largestGoodInteger(String num) {
        int result = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                int INT = num.charAt(i) - '0';
                result = Math.max(result, INT + INT * 10 + INT * 100 );
            }
        }
        return result == -1 ? "" : (result == 0 ? "000": String.valueOf(result));
    }
}
