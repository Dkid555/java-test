package com.javatest.leetcode;

public class CountAsterisks {
    public int countAsterisks(String s) {
        int c = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|')
                count++;
            if ((ch == '*') && (count % 2 == 0))
                c++;
        }
        return c;
    }
}
//You are given a string s, where every two consecutive vertical bars '|'
// are grouped into a pair. In other words, the 1st and 2nd '|' make a pair,
// the 3rd and 4th '|' make a pair, and so forth.
//
//Return the number of '*' in s, excluding the '*' between each pair of '|'.
//
//Note that each '|' will belong to exactly one pair.