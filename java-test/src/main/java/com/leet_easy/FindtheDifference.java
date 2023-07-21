package com.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class FindtheDifference {
    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> check = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            check.put(s.charAt(i), check.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (check.containsKey(t.charAt(i))) {
                if (check.put(t.charAt(i), check.get(t.charAt(i)) - 1) == 0) return t.charAt(i);
            } else return t.charAt(i);
        }
        return t.charAt(0);
    }

    public static char findTheDifference2(String s, String t) {
        char letter = 0;
        for (char charInS : s.toCharArray())
            letter ^= charInS;
        for (char charInT : t.toCharArray())
            letter ^= charInT;
        return letter;
    }


    public static void main(String[] args) {
        System.out.println(findTheDifference2("abcd", "abecd"));
        System.out.println('a' ^ 'a');
    }
}
