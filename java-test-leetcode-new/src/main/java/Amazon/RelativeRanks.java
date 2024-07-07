package com.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int[] scores1 = Arrays.copyOf(score, score.length);
        Arrays.sort(score);
        Map<Integer, String> help = new HashMap<>();
        int count = 0;
        for (int val : score){
            ++count;
            if(count == score.length) help.put(val,"Gold Medal");
            else if(count == score.length - 1) help.put(val,"Silver Medal");
            else if(count == score.length - 2) help.put(val,"Bronze Medal");
            else help.put(val,String.valueOf(score.length - count + 1));

        }
        String[] result = new String[score.length];
        for (int i = 0; i < result.length ; i++){
            result[i] = help.get(scores1[i]);
        }
        return result;
    }
}
