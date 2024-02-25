package com.leetcode;

public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.contentEquals(new StringBuilder(s).reverse()))
            return 1;
        return 2;
    }
}
