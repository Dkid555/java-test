package com.leet_easy;

//Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern2(String s) {
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i == 0 && s.charAt(i - 1) == s.charAt(s.length() - 1)) {
                String subString = s.substring(0, i);
                if (subString.repeat(s.length() / i).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }

    //The idea behind this approach is that if a string s can be constructed by repeating
    // a substring, then concatenating two copies of s together
    // and removing the first and last character would still contain s as a substring.
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern2("abcabcabcabc"));
    }
}
