package com.Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
//A transformation sequence from word beginWord to word endWord using a dictionary wordList
// is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
// in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
//
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if( !wordSet.contains(endWord) )
            return 0;
        // 3. Use set instead of queue during bfs
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();
        forwardSet.add(beginWord);
        backwardSet.add(endWord);
        wordSet.remove(endWord);
        wordSet.remove(beginWord);
        // 1. Search from entry and exit simultaneously
        return transform(forwardSet, backwardSet, wordSet);
    }

    public int transform(Set<String> forwardSet, Set<String> backwardSet, Set<String> wordSet) {
        Set<String> newSet = new HashSet<>();
        for(String fs : forwardSet) {
            char[] wordArray = fs.toCharArray();
            for(int i = 0; i < wordArray.length; ++i) {
                for(int ch = 'a'; ch <= 'z'; ++ch) {
                    char origin = wordArray[i];
                    wordArray[i] = (char) ch;
                    String target = String.valueOf(wordArray);
                    if( backwardSet.contains(target) )
                        return 2; // stop bfs when entry and exits meet
                    else if( wordSet.contains(target) && !forwardSet.contains(target) ) {
                        wordSet.remove(target); // 4. Remove visited word from wordList to decrease the search time
                        newSet.add(target);
                    }
                    wordArray[i] = origin;
                }
            }
        }
        if(newSet.isEmpty())
            return 0;
        forwardSet = newSet;
        // 2. Pick the queue with less elements to bfs
        int result = forwardSet.size() > backwardSet.size() ?
                transform(backwardSet, forwardSet, wordSet) : transform(forwardSet, backwardSet, wordSet);
        return result == 0 ? 0 : result + 1;
    }
}
