package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SmallestNotAppeared {
    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }
        int result = 1;
        while (set.contains(result)) {
            ++result;
        }
        return result;
    }
}
