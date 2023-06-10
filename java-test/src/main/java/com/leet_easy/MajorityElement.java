package com.leet_easy;

import java.util.HashMap;
import java.util.Map;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElement {
    static int majorityElement(int[] nums) {
        Map<Integer, Integer> check = new HashMap<>();
        for (int x : nums) {
            if (check.containsKey(x)) {
                check.put(x, check.get(x) + 1);
            } else check.put(x, 1);
            if (check.get(x) > nums.length / 2) return x;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{6, 5, 5}));
    }
}
