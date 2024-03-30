package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementMagicDictionary {
    class MagicDictionary {

        Map<Integer, Set<String>> map;

        public MagicDictionary() {
            this.map = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary){
                this.map.putIfAbsent(word.length(), new HashSet<>());
                this.map.get(word.length()).add(word);
            }
        }

        public boolean search(String searchWord) {
            if(this.map.containsKey(searchWord.length())){
                Set<String> words = this.map.get(searchWord.length());
                for (String word : words){
                    int replacements = 0;
                    int index = 0;
                    while (index < word.length()){
                        if(word.charAt(index) != searchWord.charAt(index)){
                            ++replacements;
                        }
                        if(replacements > 1)
                            break;
                        ++index;
                    }
                    if(replacements == 1)
                        return true;
                }
            }
            return false;
        }
    }
}
