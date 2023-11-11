package com.leetcode;

public class GenerateaStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        if (n % 2 == 1) {
            res.append("a".repeat(n));
        } else {
            res.append("a".repeat(n - 1));
            res.append('b');
        }
        return res.toString();
    }
}


//Given an integer n, return a string with n characters such
// that each character in such string occurs an odd number of times.
//
//The returned string must contain only lowercase English letters.
// If there are multiples valid strings, return any of them.