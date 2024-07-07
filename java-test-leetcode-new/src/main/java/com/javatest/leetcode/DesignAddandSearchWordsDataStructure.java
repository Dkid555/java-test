package com.javatest.leetcode;

import java.util.*;

public class DesignAddandSearchWordsDataStructure {

    static class WordDictionary {

        int max_key;
        Map<Integer, Set<String>> map;

        public WordDictionary() {
            this.map = new HashMap<>();
            this.max_key = -1;
        }

        public void addWord(String word) {
            int size = word.length();
            this.map.putIfAbsent(size, new HashSet<>());
            this.map.get(size).add(word);
            this.max_key = Math.max(this.max_key, size);
        }

        public boolean search(String word) {
            int size = word.length();
            for (int start = size; start <= max_key; ++start){
                if(this.map.containsKey(start)){
                    List<String> words_from_map = new ArrayList<>(this.map.get(start));
                    Collections.sort(words_from_map);
                    int index = 0;
                    for (String letter : words_from_map){
                        index = 0;
                        while (index < size && (letter.charAt(index) == word.charAt(index) || word.charAt(index) == '.'))
                            ++index;
                        if(index == size)
                            return true;
                    }
                }
            }
            return false;
        }
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
    }

    class WordDictionary2 {
        private Trie trie;

        /** Initialize your data structure here. */
        public WordDictionary2() {
            trie = new Trie();
        }

        public void addWord(String word) {
            Trie node = trie;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, trie);
        }

        private boolean search(String word, Trie node) {
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (c != '.' && node.children[idx] == null) {
                    return false;
                }
                if (c == '.') {
                    for (Trie child : node.children) {
                        if (child != null && search(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                    return false;
                }
                node = node.children[idx];
            }
            return node.isEnd;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

    }
}
