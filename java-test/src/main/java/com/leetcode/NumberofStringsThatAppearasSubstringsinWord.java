package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberofStringsThatAppearasSubstringsinWord {
    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;
        Set<String> substrings = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                substrings.add(word.substring(i, j + 1));
            }
        }

        for (String pattern : patterns) {
            if (substrings.contains(pattern)) {
                answer++;
            }
        }
        return answer;
    }

    public int numOfStrings2(String[] patterns, String word) {

        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                ++count;
            }
        }

        return count;
    }
}
