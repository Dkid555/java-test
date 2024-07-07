package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : magazine.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        for (char letter : ransomNote.toCharArray()) {
            if (!map.containsKey(letter)) return false;
            map.put(letter, map.get(letter) - 1);
            if (map.get(letter) == 0) map.remove(letter);
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) return false;
            map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            if (map.get(ransomNote.charAt(i)) == 0) map.remove(ransomNote.charAt(i));
        }
        return true;
    }
    //


    // one cycle
    public static boolean canConstruct3(String ransomNote, String magazine) {
        // 'a' для букв, '0' для цифр
        int[] indexes = new int[26];
        // не стоит так делать( O(n) займет перегон в массив чаров )
        for (char letter : ransomNote.toCharArray()) {

            int index = magazine.indexOf(letter, indexes[letter - 'a']);
            if (index == -1) {
                return false;
            }
            indexes[letter - 'a'] = index + 1;
        }
        return true;
    }
    ////

    public static boolean canConstruct5(String ransomNote, String magazine) {
        // 'a' для букв, '0' для цифр
        int[] indexes = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = magazine.indexOf(ransomNote.charAt(i), indexes[ransomNote.charAt(i) - 'a']);
            if (index == -1) {
                return false;
            }
            indexes[ransomNote.charAt(i) - 'a'] = index + 1;
        }
        return true;
    }

    //
    public static boolean canConstruct4(String ransomNote, String magazine) {
        Map<Character, Integer> magaz = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = magazine.indexOf(ransomNote.charAt(i), magaz.getOrDefault(ransomNote.charAt(i), 0));
            if (index == -1) return false;
            magaz.put(ransomNote.charAt(i), index + 1);
        }
        return true;
    }///


    public static void main(String[] args) {
        System.out.println(canConstruct4("aacvb", "avba"));
    }

}


//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
