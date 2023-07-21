package com.leet_easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] string = s.split(" ");
        if (string.length != pattern.length()) return false;
        Map<String, Set<Character>> mapStringtoChar = new HashMap<>();
        Map<Character, Set<String>> mapChartoString = new HashMap<>();
        String result = "";
        for (int i = 0; i < string.length; i++) {
            Set<Character> temp = mapStringtoChar.getOrDefault(string[i], new HashSet<>());
            temp.add(pattern.charAt(i));
            if (temp.size() > 1) return false;
            mapStringtoChar.put(string[i], temp);

            Set<String> temp2 = mapChartoString.getOrDefault(pattern.charAt(i), new HashSet<>());
            temp2.add(string[i]);
            if (temp2.size() > 1) return false;
            mapChartoString.put(pattern.charAt(i), temp2);

        }
        return true;
    }

    // with one hashmap, we can check the previous values of inserts in our map()
    public static boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> checkMap = new HashMap(); // we can create map
        for (Integer i = 0; i < words.length; ++i)
            if (checkMap.put(pattern.charAt(i), i) != checkMap.put(words[i], i)) // returns same previous values or null
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern2("aaab", "cat dog cat dog"));

    }

}
//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there
// is a bijection between a letter in pattern and a non-empty word in s.