package com.leetcode;

import java.util.HashSet;
import java.util.Set;


//You are given an integer array nums consisting of 2 * n integers.
//
//You need to divide nums into n pairs such that:
//
//Each element belongs to exactly one pair.
//The elements present in a pair are equal.
//Return true if nums can be divided into n pairs, otherwise return false.
public class DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] nums) {
//        Map<List<Integer>, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            if (set.contains(val)) {
                set.remove(val);
            } else set.add(val);
        }
        return set.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{1, 1, 3, 3, 4}));
    }
}


//You are given an integer array nums consisting of 2 * n integers.
//
//You need to divide nums into n pairs such that:
//
//Each element belongs to exactly one pair.
//The elements present in a pair are equal.
//Return true if nums can be divided into n pairs, otherwise return false.