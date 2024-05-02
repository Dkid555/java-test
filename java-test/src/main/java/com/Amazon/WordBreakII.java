package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        recursive_traverse(s, wordDict, 0, result, "");
        return result;
    }

    private static void recursive_traverse(String str, List<String> word_dict,
                                           int start, List<String> result, String current){
        if(start == str.length()){
            result.add(current.trim());
            return;
        }
        String current_str = str.substring(start);
        for (String prefix : word_dict){
            if(!prefix.isEmpty() && current_str.startsWith(prefix)){
                recursive_traverse(str, word_dict, start + prefix.length(), result, current + prefix + " ");
            }
        }
    }
}
//Given a string s and a
// dictionary of strings wordDict, add
// spaces in s to construct a sentence where
// each word is a valid dictionary word. Return all such possible sentences in any order.
//
//Note that the same word in the dictionary may
// be reused multiple times in the segmentation.