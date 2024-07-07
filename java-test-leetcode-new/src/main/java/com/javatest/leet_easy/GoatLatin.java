package com.javatest.leet_easy;

import java.util.Set;

public class GoatLatin {
    public static String toGoatLatin(String sentence) {
        Set<Character> vowel = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'U', 'u');
        String[] letter = sentence.split(" ");
        String res = "";
        String a = "a";
        for (String word : letter) {
            if (vowel.contains(word.charAt(0))) {
                word = word + "ma" + a;
            } else {
                String begin = word.substring(0, 1);
                word = word.substring(1) + begin + "ma" + a;
            }
            a += "a";
            res += word + " ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
