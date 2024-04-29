package com.Amazon;

import java.util.HashSet;
import java.util.Set;

public class MaximumSizeofaSetAfterRemovals {
    public static void main(String[] args) {
        System.out.println(
                maximumSetSize(new int[]{1,2,4,5}, new int[]{5, 1, 7, 8})
        );
    }
    public static int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        int common = 0;
        for (int x : nums2) {
            if (set2.contains(x)) {
                continue;
            }
            set2.add(x);
            if (set1.contains(x)) {
                ++common;
            }
        }

        int n = nums1.length;
        int c1 = Math.min(set1.size() - common, n / 2);
        int c2 = Math.min(set2.size() - common, n / 2);
        return Math.min(n, c1 + c2 + common);
    }
}
//You are given two 0-indexed integer arrays nums1 and nums2 of even length n.
//
//You must remove n / 2 elements from nums1 and n / 2 elements
// from nums2. After the removals, you insert the remaining elements of nums1 and nums2 into a set s.
//
//Return the maximum possible size of the set s.