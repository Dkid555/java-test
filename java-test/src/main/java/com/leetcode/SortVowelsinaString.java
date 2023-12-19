package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortVowelsinaString {
    public static String sortVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Integer> indexes = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char vowel = s.charAt(i);
            if (vowels.contains(vowel)) {
                indexes.add(i);
                characters.add(vowel);
            }
        }
        StringBuilder result = new StringBuilder(s);
        characters = characters.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < characters.size(); ++i) {
            result.setCharAt(indexes.get(i), characters.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }
}
