package com.Amazon.Strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); ++i){
            char ch = t.charAt(i);
            if(!map.containsKey(ch))
                return false;
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0)
                map.remove(ch);
        }
        return map.isEmpty();
    }
}
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging
// the letters of a different word or phrase, typically using all the original letters exactly once.