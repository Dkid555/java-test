package com.Amazon;

public class PalindromicSubstrings {
    int count;

    private void palin(String s, int i, int j, int n) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            ++count;
            --i;
            ++j;
        }
    }

    public int countSubstrings(String s) {
        int n = s.length();
        count = 0;
        for (int i = 0; i < n; i++) {
            palin(s, i, i, n);
            palin(s, i, i + 1, n);
        }

        return count;
    }
}
