package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumNumberofStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (String s : words) {
            StringBuilder sb = new StringBuilder(s).reverse();
            if (set.contains(sb.toString())) {
                ++count;
            } else {
                set.add(s);
            }
        }
        return count;

    }
}
