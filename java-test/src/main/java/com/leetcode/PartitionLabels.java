package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        char[] str = s.toCharArray();
        Map<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < str.length; ++i) {
            hmap.put(str[i], i);
        }
        int temp = hmap.get(str[0]),
                prev = 0;
        for (int i = 0; i < str.length; ++i) {
            if (hmap.get(str[i]) > temp) {
                temp = hmap.get(str[i]);
            }
            if (i == temp) {
                result.add(temp - prev + 1);
                prev = temp + 1;
            }
        }
        return result;
    }
}
//You are given a string s. We want to partition the string into as many parts as possible so that each letter
// appears in at most one part.
//
//Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//Return a list of integers representing the size of these parts.