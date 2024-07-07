package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            int freq = mapFreq.getOrDefault(num, 0) + 1;
            mapFreq.put(num, freq);
            int prev = max;
            max = Math.max(max, freq);
            if (max != prev)
                sum = 0;
            if (freq == max)
                sum += freq;
        }
        return sum;
    }
}
