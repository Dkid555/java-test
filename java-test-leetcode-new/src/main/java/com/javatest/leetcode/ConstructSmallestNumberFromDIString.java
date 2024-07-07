package com.javatest.leetcode;

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        char ch = '1';
        for (int i = 0; i < pattern.length(); i++) {
            char current = pattern.charAt(i);
            temp.append(ch++);
            if (current == 'I') {
                result.append(temp.reverse());
                temp = new StringBuilder();
            }
        }
        temp.append(ch++);
        result.append(temp.reverse());
        return result.toString();
    }
}
//You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.
//
//A 0-indexed string num of length n + 1 is created using the following conditions:
//
//num consists of the digits '1' to '9', where each digit is used at most once.
//If pattern[i] == 'I', then num[i] < num[i + 1].
//If pattern[i] == 'D', then num[i] > num[i + 1].
//Return the lexicographically smallest possible string num that meets the conditions.