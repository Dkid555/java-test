package com.Amazon.Tree;

import java.util.Dictionary;

public class DesignAddandSearchWordsDataStructure {



    private static class WordDictionary {
        private static class Trie{
            Trie[] children = new Trie[26];
            boolean isEnd = false;
        }
        private Trie trie;
        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            Trie node = trie;
            for (char ch : word.toCharArray()){
                int idx = ch - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, trie);
        }

        private boolean search(String word, Trie trie){
            Trie node = trie;
            for(int i = 0; i < word.length(); ++i){
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if(ch != '.' && node.children[idx] == null)
                    return false;
                if(ch == '.'){
                    for(Trie child : node.children){
                        if(child != null && search(word.substring(i+1), child)){
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
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("bad");
        dictionary.addWord("cat");
        dictionary.addWord("long");
        System.out.println(dictionary.search(".am"));
    }
}
///Design a data structure that supports adding new words and finding if a string matches any previously added string.
//
//Implement the WordDictionary class:
//
//WordDictionary() Initializes the object.
//void addWord(word) Adds word to the data structure, it can be matched later.
//bool search(word) Returns true if there is any string in the data structure
// that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.