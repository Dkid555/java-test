package com.javatest.leetcode;

import java.util.Set;

public class ReplaceAllDigitswithCharacters {
    public String replaceDigits(String s) {
        Set<Character> set = Set.of(
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
        );
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(set.contains(ch) && i > 0){
                ch = (char) (s.charAt(i - 1) + (ch - '0'));
            }
            result.append(ch);
        }
        return result.toString();
    }
}
