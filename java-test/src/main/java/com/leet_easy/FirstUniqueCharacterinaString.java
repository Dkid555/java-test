package com.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), Integer.MAX_VALUE);
            } else map.put(s.charAt(i), i);
        }
        int min = Integer.MAX_VALUE;
        for (Character character : map.keySet()
        ) {
            min = Math.min(min, map.get(character));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // On^2
    public static int firstUniqueChar2(String str) {
        int min = Integer.MAX_VALUE;
        for (char character = 'a'; character <= 'z'; character++) {
            int index = str.indexOf(character);
            if (index != -1 && index == str.lastIndexOf(character)) {
                min = Math.min(min, index);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar2("aabb"));
    }

}
