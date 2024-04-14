package com.Amazon.Strings;

import java.util.*;

public class GroupAnagrams {
    private static class Word {
        char[] chars;

        public Word(char[] chars) {
            this.chars = chars;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Word other = (Word) obj;
            return areArraysEqual(chars, other.chars);
        }

        private boolean areArraysEqual(char[] arr1, char[] arr2) {
            if (arr1 == arr2)
                return true;
            if (arr1 == null || arr2 == null || arr1.length != arr2.length)
                return false;
            Map<Character, Integer> charCount1 = countCharacters(arr1);
            Map<Character, Integer> charCount2 = countCharacters(arr2);
            return charCount1.equals(charCount2);
        }

        private Map<Character, Integer> countCharacters(char[] arr) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : arr) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
            return charCount;
        }

        @Override
        public int hashCode() {
            int primeFactorsProduct = 1;
            for (char c : chars) {
                primeFactorsProduct *= primeFactors[c - 'a']; // Assuming lowercase letters
            }
            return primeFactorsProduct;
        }
        private static final int[] primeFactors = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151,
                157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233,
                239, 241, 251
        };
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Word, List<String>> map_ofStr = new HashMap<>();
        for (String string : strs){
            Word word = new Word(string.toCharArray());
            map_ofStr.putIfAbsent(word, new ArrayList<>());
            map_ofStr.get(word).add(string);
        }
        return map_ofStr.values().stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

//        System.out.println(new Word("eat".toCharArray()).equals(new Word("tea".toCharArray())));

//        System.out.println(new Word("eat".toCharArray()).equals(new Word("tea".toCharArray())));

    }
}
