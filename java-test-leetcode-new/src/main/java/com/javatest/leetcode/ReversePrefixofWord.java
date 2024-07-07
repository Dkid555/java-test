package com.javatest.leetcode;

public class ReversePrefixofWord {
    public static String reversePrefix(String word, char ch) {
        int firstOcc = word.indexOf(ch);
        return new StringBuilder(word.substring(0, firstOcc + 1)).reverse().toString() + word.substring(firstOcc + 1);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcded", 'd'));
    }
}
