package com.meta.other;

import java.util.HashMap;
import java.util.Map;

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        Map<Character, String> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, "") + ch);
        }
        if (map.containsKey('1')) {
            String ones = map.get('1');
            String zeros = map.getOrDefault('0', "");
            ones = ones.substring(1);
            zeros += '1';
            return ones + zeros;
        } else
            return s;

    }
}
