package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DecodetheMessage {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> decode = new HashMap<>();
        char start = 'a';
        for (int i = 0; i < key.length(); i++) {
            char Key = key.charAt(i);
            if (!decode.containsKey(Key) && Key != ' ') {
                decode.put(Key, start++);
            } else if (Key == ' ')
                decode.put(Key, Key);
        }

        StringBuilder result = new StringBuilder(message);

        for (int i = 0; i < result.length(); ++i) {
            if (decode.containsKey(result.charAt(i)))
                result.setCharAt(i, decode.get(result.charAt(i)));
        }
        return result.toString();
    }
}
