package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        int[] scores1 = Arrays.copyOf(score, score.length);
        Arrays.sort(score);
        Map<Integer, String> help = new HashMap<>();
        int count = 0;
        for (int val : score) {
            count++;
            if (count == score.length) help.put(val, "Gold Medal");
            else if (count == score.length - 1) help.put(val, "Silver Medal");
            else if (count == score.length - 2) help.put(val, "Bronze Medal");
            else help.put(val, String.valueOf(score.length - count + 1));

        }
        String[] result = new String[score.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = help.get(scores1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

}
//You are given an integer array score of size n, where score[i]
// is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
//
//The athletes are placed based on their scores, where the 1st place athlete
// has the highest score, the 2nd place athlete has the 2nd highest score, and so on.
// The placement of each athlete determines their rank:
//
//The 1st place athlete's rank is "Gold Medal".
//The 2nd place athlete's rank is "Silver Medal".
//The 3rd place athlete's rank is "Bronze Medal".
//For the 4th place to the nth place athlete, their rank
// is their placement number (i.e., the xth place athlete's rank is "x").
//Return an array answer of size n where answer[i] is the rank of the ith athlete.