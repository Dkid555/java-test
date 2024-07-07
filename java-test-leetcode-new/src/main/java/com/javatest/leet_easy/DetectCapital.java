package com.javatest.leet_easy;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) return true;
        if (!String.valueOf(word.charAt(0)).equals(String.valueOf(word.charAt(0)).toUpperCase())) return false;
        for (int i = 1; i < word.length(); i++) {
            if (!String.valueOf(word.charAt(i)).equals(String.valueOf(word.charAt(i)).toLowerCase())) return false;
        }
        return true;
    }

    public static boolean detectCapitalUse2(String word) {
        int capitals = 0;
        int lower = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) ++lower;
            else ++capitals;
        }
        if (capitals == word.length() || lower == word.length()) return true;
        return capitals == 1 && Character.isUpperCase(word.charAt(0));
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Google"));
    }
}

//We define the usage of capitals in a word to be right when one of the following cases holds:
//
//All letters in this word are capitals, like "USA".
//All letters in this word are not capitals, like "leetcode".
//Only the first letter in this word is capital, like "Google".
//Given a string word, return true if the usage of capitals in it is right.