package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLuckyIntegerinanArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr){
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            if(freq > num){
                set.remove(num);
            }
            if (freq == num)
                set.add(num);
        }
        if(set.isEmpty())
            return -1;
        else
            return set.stream().max(Integer::compareTo).orElse(-1);
    }

    public int findLucky2(int[] arr) {
        int[] FreqCount = new int[501];
        for(int num : arr)
            ++FreqCount[num];
        for(int i = 500; i > 0; --i){
            if(i == FreqCount[i])
                return i;
        }
        return -1;
    }
}
//Given an array of integers arr, a lucky integer is an integer that
// has a frequency in the array equal to its value.
//
//Return the largest lucky integer in the array. If there is no lucky integer return -1.