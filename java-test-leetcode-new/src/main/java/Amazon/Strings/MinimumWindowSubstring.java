package com.Amazon.Strings;

public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() ||
                s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        for (char c : t.toCharArray()) {
            map[c]++; // карта чаров
        }

        char[] ch_S = s.toCharArray();

        while (end < ch_S.length) {
            if (map[ch_S[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[ch_S[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(ch_S, startIndex, minLen);
    }
}
