package com.javatest.leet_easy;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int current = 1, previous = 0, result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                current++;
            else {
                result += Math.min(current, previous);
                previous = current;
                current = 1;
            }
        }
        return result + Math.min(current, previous);
    }
}
//Given a binary string s, return the number of non-empty
// substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//Substrings that occur multiple times are counted the number of times they occur.