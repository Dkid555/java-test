package com.leetcode;

public class MaximumNumberofWordsFoundinSentences {
    public int mostWordsFound(String[] sentences) {
        int max = -1;
        for (String sentence : sentences) {
            max = Math.max(sentence.split(" ").length, max);
        }
        return max;
    }
}
