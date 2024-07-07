package com.Amazon.Strings;

import java.util.Arrays;

public class DetermineifTwoStringsAreClose {

    public static boolean closeStrings(String word1, String word2) {
        var map_word1 = new int[26];
        var map_word2 = new int[26];

        for (var c : word1.toCharArray()) map_word1[c - 'a']++;
        for (var c : word2.toCharArray()) map_word2[c - 'a']++;

        for (var i = 0; i < 26; i++) {
            if (map_word1[i] == 0 && map_word2[i] != 0) return false;
            if (map_word1[i] != 0 && map_word2[i] == 0) return false;
        }
        Arrays.sort(map_word1);
        Arrays.sort(map_word2);

        return Arrays.equals(map_word1, map_word2);
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("aabbbc", "bbaaaz"));
    }
}
//Two strings are considered close if you can attain one from the other using the following operations:
//
//Operation 1: Swap any two existing characters.
//For example, abcde -> aecdb
//Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
//For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
//You can use the operations on either string as many times as necessary.
//
//Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.