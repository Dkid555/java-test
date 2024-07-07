package com.Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_ {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();
        forwardSet.add(beginWord);
        backwardSet.add(endWord);
        wordSet.remove(endWord);
        wordSet.remove(beginWord);
        return transform(forwardSet, backwardSet, wordSet);
    }


    public int transform(Set<String> forwardSet, Set<String> backwardSet, Set<String> wordSet) {
        Set<String> newSet = new HashSet<>();

        for (String word : forwardSet){
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                for (int ch = 'a'; ch <= 'z'; ++ch) {
                    char original_char = chars[i];
                    chars[i] = (char) ch;
                    String newWord = String.valueOf(chars);
                    if (backwardSet.contains(newWord))
                        return 2;
                    else if (wordSet.contains(newWord) && !forwardSet.contains(newWord)) {
                        newSet.add(newWord);
                        wordSet.remove(newWord);
                    }

                    chars[i] = original_char;
                }
            }
        }
        if(newSet.isEmpty())
            return 0;
        forwardSet = newSet;
        int result = forwardSet.size() > backwardSet.size() ? transform(backwardSet, forwardSet, wordSet)
                : transform(forwardSet, backwardSet, wordSet);
        return result == 0 ? 0 : result + 2;
    }
}
