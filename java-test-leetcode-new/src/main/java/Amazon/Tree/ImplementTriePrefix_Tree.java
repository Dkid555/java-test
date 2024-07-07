package com.Amazon.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementTriePrefix_Tree {
    class Trie {
        private Set<String> words;

        private Map<String, Integer> prefixes;
        public Set<String> getWords() {
            return words;
        }

        public void setWords(Set<String> words) {
            this.words = words;
        }

        public Map<String, Integer> getPrefixes() {
            return prefixes;
        }

        public void setPrefixes(Map<String, Integer> prefixes) {
            this.prefixes = prefixes;
        }

        public Trie() {
            this.words = new HashSet<>();
            this.prefixes = new HashMap<>();
        }




        public void insert(String word) {
            if(this.words.contains(word))
                return;
            this.words.add(word);
            String prefix = "";
            for(int i = 0; i < word.length(); ++i){
                prefix += word.charAt(i);
                this.prefixes.put(prefix, this.prefixes.getOrDefault(prefix, 0) + 1);
            }
        }

        public boolean search(String word) {
            return this.words.contains(word);
        }

        public boolean startsWith(String prefix) {
            return this.prefixes.containsKey(prefix);
        }
    }
}
//A trie (pronounced as "try") or prefix tree is a tree data
// structure used to efficiently store and retrieve keys in a
// dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
//
//Implement the Trie class:
//
//Trie() Initializes the trie object.
//void insert(String word) Inserts the string word into the trie.
//boolean search(String word) Returns true if the string word is in the
// trie (i.e., was inserted before), and false otherwise.
//boolean startsWith(String prefix) Returns true if there is a previously
// inserted string word that has the prefix prefix, and false otherwise.