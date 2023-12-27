package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofArithmeticTriplets {
    public static int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int countResult = 0;
        for (int num : nums) {
            if (map.containsKey(num - diff)) {
                List<Integer> temp = map.get(num - diff);
                map.remove(num - diff);
                temp.add(num);
                if (temp.size() == 3) {
                    ++countResult;
                    temp.remove(0);
                }
                map.put(num, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                map.put(num, temp);
            }
        }
        return countResult;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 9};
        System.out.println(arithmeticTriplets(nums, 2));
    }
}
