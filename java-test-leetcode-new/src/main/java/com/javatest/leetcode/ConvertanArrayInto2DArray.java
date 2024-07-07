package com.javatest.leetcode;


import java.util.*;

/*
* You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.
* */
public class ConvertanArrayInto2DArray {
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums
        ) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        helper(result, map);

        return result;
    }

    public static void helper(List<List<Integer>> result, Map<Integer, Integer> map) {
        if (map.isEmpty())
            return;
        List<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>(map.keySet());
        for (int key : set) {
            temp.add(key);
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) map.remove(key);
        }
        result.add(temp);
        helper(result, map);
    }

    public static void main(String[] args) {
        System.out.println(findMatrix(new int[]{1, 2, 3, 4}));
    }


    // works faster
    public List<List<Integer>> findMatrix2(int[] nums) {
        int[] arr = new int[nums.length + 1];

        int maxi = 0;

        for (int num : nums) {
            arr[num]++;
            maxi = Math.max(maxi, arr[num]);
        }

        List<List<Integer>> list = new ArrayList<>();
        while (maxi > 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    temp.add(i);
                    arr[i]--;
                }
            }
            list.add(temp);
            maxi--;
        }

        return list;


    }
}
