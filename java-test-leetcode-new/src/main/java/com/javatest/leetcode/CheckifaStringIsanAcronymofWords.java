package com.javatest.leetcode;

import java.util.List;

public class CheckifaStringIsanAcronymofWords {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder result= new StringBuilder();
        for(String word : words){
            result.append(word.charAt(0));
        }
        return result.toString().equals(s);
    }
}
