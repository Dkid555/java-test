package com.Amazon;

public class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        int firstOcc = word.indexOf(ch);
        return new StringBuilder(word.substring(0, firstOcc + 1)).reverse() + word.substring(firstOcc + 1);
    }
}
