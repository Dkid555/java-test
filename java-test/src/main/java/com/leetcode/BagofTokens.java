package com.leetcode;

import java.util.Arrays;

public class BagofTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens == null || tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int left = 0, score = 0, maxScore = 0, right = tokens.length - 1;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left++];
                score++;
            } else if (score > 0){
                power += tokens[right--];
                score--;
            } else break;
            maxScore = score > maxScore? score : maxScore;
        }
        return maxScore;
    }
}
