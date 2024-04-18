package com.Amazon.Strings;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {

    private static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;
    }

    private static void fill_dictionary(Trie trie, String word) {
        Trie temp = trie;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (temp.children[idx] == null) {
                temp.children[idx] = new Trie();
            }
            temp = temp.children[idx];
        }
        temp.isEnd = true;
    }

    //    private static int count_words_used(Trie trie, String word, int index){
//        if(index == word.length())
//            return 0;
//        Trie temp = trie;
//        for (int current_index = index; current_index < word.length(); ++current_index){
//            int idx = word.charAt(current_index) - 'a';
//            if(temp.children[idx] == null)
//                return -1;
//            if(temp.children[idx].isEnd){
//                //Recursively checking for the remaining string.
//                int next = count_words_used(temp.children[idx], word, current_index + 1);
//                //If the string can be formed with the word.
//                if(next != -1){
//                    return next + 1;
//                }
//            }
//            temp = temp.children[idx];
//        }
//        return -1;
//    }
    public static boolean isPossible(Trie trie, String word, int index, Boolean[] dp) {
        if (index == word.length())
            return true;
        if (dp[index] != null)
            return dp[index];
        Trie curr = trie;
        for (int j = index; j < word.length(); j++) {
            char ch = word.charAt(j);
            if (curr.children[ch - 'a'] == null)
                return dp[index] = false;
            if (index == 0 && j == word.length() - 1)
                return dp[index] = false;
            curr = curr.children[ch - 'a'];
            if (curr.isEnd) {
                if (isPossible(trie, word, j + 1, dp))
                    return dp[index] = true;
            }
        }
        return dp[index] = false;
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        for (String word : words)
            fill_dictionary(trie, word);

        for (String word : words) {
//            if(count_words_used(trie, word, 0) > 1)
//                result.add(word);
            if (isPossible(trie, word, 0, new Boolean[word.length()]))
                result.add(word);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }
}
//Given an array of strings words (without duplicates),
// return all the concatenated words in the given list of words.
//
//A concatenated word is defined as a string that is comprised entirely
// of at least two shorter words (not necessarily distinct) in the given array.