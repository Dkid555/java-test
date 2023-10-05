package com.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class FirstLettertoAppearTwice {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) == 2)
                return s.charAt(i);
        }
        return s.charAt(0);
    }
}
