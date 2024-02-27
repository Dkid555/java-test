package com.leetcode;

public class DecryptStringfromAlphabettoIntegerMapping {
    public String freqAlphabets(String str) {
        for (int i = 10; i <= 26; i++) {
            str = str.replaceAll(i + "#", (char) ('a' + (i - 1)) + "");
        }
        for (int i = 1; i <= 9; i++) {
            str = str.replaceAll(i + "", (char) ('a' + (i - 1)) + "");
        }
        return str;
    }
}
