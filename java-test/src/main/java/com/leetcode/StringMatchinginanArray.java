package com.leetcode;

import java.util.*;

public class StringMatchinginanArray {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> exists = new HashSet<>();

        for(int i = 0; i < words.length; ++i){

            for (int j = i + 1; j < words.length; ++j){
                if(words[j].contains(words[i]))
                    exists.add(words[i]);
            }
        }

        return exists.stream().toList();

    }
}
