package com.javatest.leetcode;

import java.util.Set;
import java.util.stream.Collectors;

public class CounttheNumberofConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedd = allowed.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        int result = 0;
        for (String word : words) {
            boolean check = true;
            for (Character ch : word.toCharArray()) {
                if (!allowedd.contains(ch)) {
                    check = false;
                    break;
                }
            }
            result += check ? 1 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}
