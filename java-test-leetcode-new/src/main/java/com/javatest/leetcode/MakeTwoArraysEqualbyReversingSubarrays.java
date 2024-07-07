package com.javatest.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakeTwoArraysEqualbyReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int val : target) {
            if (!map.containsKey(val)) {
                return false;
            } else {
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0)
                    map.remove(val);
            }
        }
        return true;
    }

    public static boolean canBeEqual2(int[] target, int[] arr) {
        if (target.length != arr.length)
            return false;
        Set<Integer> helper = new HashSet<>();
        int[] map = new int[1001];
        for (int i = 0; i < target.length; ++i) {
            ++map[target[i]];
            --map[arr[i]];
            if (map[target[i]] == 0)
                helper.remove(target[i]);
            if (map[arr[i]] == 0)
                helper.remove(arr[i]);
            if (map[arr[i]] != 0)
                helper.add(arr[i]);
            if (map[target[i]] != 0)
                helper.add(target[i]);
        }
        return helper.isEmpty();
    }

    public static boolean canBeEqual3(int[] target, int[] arr) {
        if (target.length != arr.length)
            return false;
        int[] map = new int[1001];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < target.length; ++i) {
            ++map[target[i]];
            --map[arr[i]];
            max = Math.max(max, Math.max(target[i], arr[i]));
        }
        for (int i = 0; i <= max; ++i) {
            if (map[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual2(
                new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }
}
