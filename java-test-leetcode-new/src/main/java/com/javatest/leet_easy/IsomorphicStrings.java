package com.javatest.leet_easy;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic
// if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while
// preserving the order of characters. No two characters may map to the same
// character, but a character may map to itself.
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] wordS = new int[200];
        int[] wordT = new int[200];
        for (int i = 0; i < s.length(); i++) {
            if (wordS[s.charAt(i)] != wordT[t.charAt(i)]) return false;
            wordS[s.charAt(i)] = i + 1;
            wordT[t.charAt(i)] = i + 1;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }
}
