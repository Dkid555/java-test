package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {

    //don't checks indexes
    static boolean isSubsequence(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            else map.put(t.charAt(i), 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) return false;
            if (map.get(s.charAt(i)) == 0) return false;
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        return true;
    }

    static boolean isSubsequence2(String s, String t) {
        int c = 0;
        for (int i = 0; i < t.length(); i++) {
            if (c == s.length()) {
                return true;
            }
            if (t.charAt(i) == s.charAt(c)) {
                c++;
            }
        }
        return c == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence2("bb", "ahbgdc"));
    }
}
