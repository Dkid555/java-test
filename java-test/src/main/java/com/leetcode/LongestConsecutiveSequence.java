package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }

        int longestSeq = 0;
        for (int val : nums) {
            if (!hs.contains(val - 1)) {
                int count = 1;
                int currVal = val;
                while (hs.contains(currVal + 1)) {
                    count++;
                    currVal++;
                }

                longestSeq = Math.max(longestSeq, count);
            }
        }

        return longestSeq;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
