package com.leet_easy;

import java.util.HashMap;
import java.util.Map;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

public class ContainsDuplicates {
    static boolean check(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(check(new int[]{1, 2, 3, 4}));
    }
}
