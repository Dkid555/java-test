package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharacterstoMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }
        int totalCharCount = 0;
        for (String s : words) {
            totalCharCount += s.length();
        }
        if (totalCharCount % words.length != 0) {
            return false;
        }

        int[] myMap = new int[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                myMap[c - 'a']++;
            }
        }
        for (int i : myMap) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean makeEqual2(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words){
            for (char ch : word.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int len = words.length;
        for (Map.Entry<Character, Integer> Entry : map.entrySet()){
            if(Entry.getValue() % len != 0)
                return false;
        }
        return true;
    }
}
