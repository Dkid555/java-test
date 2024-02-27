package com.leetcode;

public class MaximumScoreAfterSplittingaString {
    public int maxScore(String s) {
        int ans = Integer.MIN_VALUE;
        int n = s.length();

        int ones = 0;
        int zero = 0;

        for (int i = 0;i < n - 1; i ++) {
            if (s.charAt(i) == '0') zero++;
            else {
                ones++;
                zero--;
            }
            if(ans < zero) ans = zero;
        }
        ones += s.charAt(n - 1) == '1' ? 1 : 0;
        return ones + ans;
    }
}
