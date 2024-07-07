package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;


//Given a string licensePlate and an array of strings words, find the shortest completing word in words.
//
//A completing word is a word that contains all the letters in licensePlate.
// Ignore numbers and spaces in licensePlate, and treat letters as case insensitive.
// If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.
//
//For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case),
// and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".
//
//Return the shortest completing word in words. It is guaranteed an answer exists.
// If there are multiple shortest completing words, return the first one that occurs in words.
public class ShortestCompletingWord {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int min = Integer.MAX_VALUE;
        String result = "";
//        licensePlate = licensePlate.toLowerCase();
        Map<Character, Integer> licensePlateMap = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            if (!Character.isDigit(licensePlate.charAt(i)) && licensePlate.charAt(i) != ' ') {
                licensePlateMap.put(Character.toLowerCase(licensePlate.charAt(i)), licensePlateMap.getOrDefault(Character.toLowerCase(licensePlate.charAt(i)), 0) + 1);
            }
        }
        for (String word : words) {
            Map<Character, Integer> licensePlateMapCopy = new HashMap<>(licensePlateMap);
            for (int i = 0; i < word.length(); i++) {
                if (licensePlateMapCopy.containsKey(word.charAt(i))) {
                    licensePlateMapCopy.put(word.charAt(i), licensePlateMapCopy.get(word.charAt(i)) - 1);
                    if (licensePlateMapCopy.get(word.charAt(i)) <= 0)
                        licensePlateMapCopy.remove(word.charAt(i));
                }
            }
            if (licensePlateMapCopy.isEmpty() && Math.min(word.length(), min) < min) {
                min = word.length();
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"});
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"stepss", "steps", "stripe", "stepple"}));
    }
}
