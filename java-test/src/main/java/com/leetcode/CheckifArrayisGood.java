package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckifArrayisGood {
    public static boolean isGood(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length - 2; i++) {
            map.put(i, 1);
        }
        map.put(nums.length - 1, 2);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            } else
                return false;
        }
        return map.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isGood(new int[]{1, 3, 3, 2}));
    }

    public boolean isGood2(int[] nums) {
        int n = nums.length;
        int arrLen = n - 1;
        int[] arr = new int[arrLen];
        for (int num : nums) {
            int index = num - 1;
            if (index > arrLen - 1 || index <= -1) return false;
            arr[index]++;
        }
        if (arr[arrLen - 1] != 2) return false;
        for (int i = 0; i < arrLen - 1; i++) {
            if (arr[i] != 1) return false;
        }
        return true;
    }
}
//You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
//
//base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which
// contains 1 to n - 1 exactly once, plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
//
//Return true if the given array is good, otherwise return false.
//
//Note: A permutation of integers represents an arrangement of these numbers.