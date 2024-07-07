package com.javatest.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {

        Set<Character> set = new HashSet<>();

        String baloon = "balloon";

        for (int i = 0; i < baloon.length(); i++) {
            set.add(baloon.charAt(i));
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char word = text.charAt(i);
            if (set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        if (map.size() < 5) return 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char word = entry.getKey();
            int count = entry.getValue();
            if (word == 'l' || word == 'o') {
                min = Math.min(min, (int) (double) (count / 2));
            } else {
                min = Math.min(min, count);
            }
        }
        return min;
    }

    public int maxNumberOfBalloons2(String text) {
        var arr = new int[26];
        var arr1 = new int[26];

        for (var ch : text.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (var ch : "balloon".toCharArray()) {
            arr1[ch - 'a']++;
        }

        var res = 1000000;
        for (var ch : "balloon".toCharArray()) {
            res = Math.min(res, arr[ch - 'a'] / arr1[ch - 'a']);
        }
        return res;
    }
}
