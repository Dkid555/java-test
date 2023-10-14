package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> Appears = new HashMap<>();
        Set<Integer> Result = new HashSet<>();
        for (int num : nums) {
            Appears.put(num, Appears.getOrDefault(num, 0) + 1);
            if (Appears.get(num) == 1) {
                Result.add(num);
            } else Result.remove(num);
        }
        return Result.stream().mapToInt(Number::intValue).toArray();
    }


    //

    public int[] singleNumber2(int[] nums) {
        int xorr = 0;
        for (int num : nums) xorr ^= num;

        int[] res = new int[2];

        int setBit = xorr & -xorr;

        for (int num : nums) {
            if ((setBit & num) != 0) res[0] ^= num;
        }
        res[1] = res[0] ^ xorr;
        return res;
    }
}
//Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
//
//You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.