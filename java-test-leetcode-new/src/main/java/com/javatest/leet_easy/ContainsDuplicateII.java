package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//find values that are equal and diff of indexes is less than k

public class ContainsDuplicateII {

    //with stack
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int fi = map.get(nums[i]).pop();
                if (Math.abs(fi - i) <= k)
                    return true;

            }
            Stack<Integer> temp = map.getOrDefault(nums[i], new Stack<>());
            temp.push(i);
            map.put(nums[i], temp);

        }
        return false;
    }

    //without stack


    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int fi = map.get(nums[i]);
                if (Math.abs(fi - i) <= k)
                    return true;

            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}


