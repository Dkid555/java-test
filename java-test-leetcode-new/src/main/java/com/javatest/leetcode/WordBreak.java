package com.javatest.leetcode;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    //
    public boolean wordBreak2(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreak(s, wordDict, 0, memo);
    }

    private boolean wordBreak(String s, List<String> wordDict, int offset, Boolean[] memo) {
        if (offset == s.length()) return true;
        if (memo[offset] != null) return memo[offset];
        for (String word : wordDict) {
            if (s.startsWith(word, offset)) {
                boolean res = wordBreak(s, wordDict, offset + word.length(), memo);
                if (res) return true;
                memo[offset] = res;
            }
        }
        return false;
    }
}
//Given a string s and a dictionary of strings wordDict,
// return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//