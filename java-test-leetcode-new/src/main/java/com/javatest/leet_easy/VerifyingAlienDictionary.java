package com.javatest.leet_easy;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            //setting the index what it in there alphabet (in order)
            charMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], charMap) > 0) {
                return false;
            }
        }
        return true;
    }

    public int compare(String word1, String word2, int[] charMap) {
        int i = 0;
        int j = 0;
        int difference = 0;

        while (i < word1.length() && j < word2.length() && difference == 0) {
            difference = charMap[word1.charAt(i) - 'a'] - charMap[word2.charAt(i) - 'a'];
            i++;
            j++;
        }

        if (difference == 0) {
            //when word1 length will be smaller than word2 it will return true as we have gone through whole while loop (difference value is zero)
            return word1.length() - word2.length();
        } else {
            return difference;
        }
    }
}
