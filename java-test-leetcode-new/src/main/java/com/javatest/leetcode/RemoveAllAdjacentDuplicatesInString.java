package com.javatest.leetcode;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char CHAR = s.charAt(i);
            if (result.isEmpty() || result.charAt(result.length() - 1) != CHAR) {
                result.append(CHAR);
            } else {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }
}
