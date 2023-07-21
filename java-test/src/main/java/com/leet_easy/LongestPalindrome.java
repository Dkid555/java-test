package com.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> mapOfChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            mapOfChars.put(s.charAt(i), mapOfChars.getOrDefault(s.charAt(i), 0) + 1);
        boolean OddCheck = false;
        int count = 0;
        for (int values : mapOfChars.values()) {
            if ((values & 1) == 1) {
                OddCheck = true; // нечетные есть
            }
            count += ((values & 1) == 0) ? values : values - 1;
        }
        return count += OddCheck ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("adam"));
    }

    public static int longestPalindrome2(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i)]++;
        boolean OddCheck = false;
        int count = 0;
        for (int values : map) {
            if ((values & 1) == 1) {
                OddCheck = true; // нечетные есть
            }
            count += ((values & 1) == 0) ? values : values - 1;
        }
        return count += OddCheck ? 1 : 0;
    }

}
//Given a string s which consists of lowercase or uppercase letters,
// return the length of the longest palindrome that can be built with those letters.
//
//Letters are case sensitive, for example, "Aa" is not considered a palindrome here.