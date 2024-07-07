package com.javatest.leet_easy;

public class ValidAnagram {
    static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int idx = 0; idx < s.length(); idx++) {
            counter[s.charAt(idx) - 'a']++;
            counter[t.charAt(idx) - 'a']--;
        }
        for (int idx : counter) {
            if (idx != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("manapa", "panama"));
    }
}
