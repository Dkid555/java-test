package com.leetcode;

public class CheckIfTwoStringArraysareEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"as", "parade"}, new String[]{"asparade"}));
    }
}
