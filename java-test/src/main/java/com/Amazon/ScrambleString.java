package com.Amazon;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));
    }
    // for storing already solved problems
    private static Map<String, Boolean> mp = new HashMap<>();

    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();

        // if both strings are not equal in size
        if (s2.length() != n)
            return false;

        // if both strings are equal
        if (s1.equals(s2))
            return true;

        // if code is reached to this condition then following this are sure:
        // 1. size of both string is equal
        // 2. string are not equal
        // so size is equal (where size==1) and they are not equal then obviously false
        // example 'a' and 'b' size is equal ,string are not equal
        if (n == 1)
            return false;

        String key = s1 + " " + s2;

        // check if this problem has already been solved
        if (mp.containsKey(key))
            return mp.get(key);

        // for every iteration it can two condition
        // 1.we should proceed without swapping
        // 2.we should swap before looking next
        for (int i = 1; i < n; i++) {
            // ex of without swap: gr|eat and rg|eat
            boolean withoutswap = (
                    // left part of first and second string
                    isScramble(s1.substring(0, i), s2.substring(0, i))

                            &&

                            // right part of first and second string;
                            isScramble(s1.substring(i), s2.substring(i))
            );

            // if without swap give us right answer then we do not need
            // to call the recursion withswap
            if (withoutswap) {
                mp.put(key, true);
                return true;
            }

            // ex of withswap: gr|eat rge|at
            // here we compare "gr" with "at" and "eat" with "rge"
            boolean withswap = (
                    // left part of first and right part of second
                    isScramble(s1.substring(0, i), s2.substring(n - i))

                            &&

                            // right part of first and left part of second
                            isScramble(s1.substring(i), s2.substring(0, n - i))
            );

            // if withswap give us right answer then we return true
            // otherwise the for loop do it work
            if (withswap) {
                mp.put(key, true);
                return true;
            }
            // we are not returning false in else case
            // because we want to check further cases with the for loop
        }
        mp.put(key, false);
        return false;
    }
}
//We can scramble a string s to get a string t using the following algorithm:
//
//If the length of the string is 1, stop.
//If the length of the string is > 1, do the following:
//Split the string into two non-empty substrings at a random index, i.e.,
// if the string is s, divide it to x and y where s = x + y.
//Randomly decide to swap the two substrings or to keep them in the same order.
// i.e., after this step, s may become s = x + y or s = y + x.
//Apply step 1 recursively on each of the two substrings x and y.
//Given two strings s1 and s2 of the same length,
// return true if s2 is a scrambled string of s1, otherwise, return false.