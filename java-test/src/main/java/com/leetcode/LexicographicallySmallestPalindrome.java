package com.leetcode;

public class LexicographicallySmallestPalindrome {

    public String makeSmallestPalindrome2(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            char c = (char) Math.min(s.charAt(i), s.charAt(s.length() - 1 - i));
            s = s.substring(0, i) + c + s.substring(i + 1, s.length() - i - 1) + c + s.substring(s.length() - i);
        }
        return s;
    }
    public String makeSmallestPalindrome(String s) {
        char[] Chars = s.toCharArray();
        int left = 0, right = Chars.length - 1;
        while (left < right){
            char min = (char) Math.min(Chars[left], Chars[right]);
            Chars[left++] = min;
            Chars[right--] = min;
        }
        return String.valueOf(Chars);

    }
}
