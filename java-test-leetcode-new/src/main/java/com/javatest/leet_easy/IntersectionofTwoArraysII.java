package com.javatest.leet_easy;

import java.util.*;

public class IntersectionofTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1 = new HashMap<>();
        for (int val : nums1) {
            num1.put(val, num1.getOrDefault(val, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int val : nums2) {
            if (num1.containsKey(val) && num1.get(val) > 0) {
                res.add(val);
                num1.put(val, num1.get(val) - 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
//Given two integer arrays nums1 and nums2,
// return an array of their intersection.
// Each element in the result must appear as many
// times as it shows in both arrays and you may return the result in any order.