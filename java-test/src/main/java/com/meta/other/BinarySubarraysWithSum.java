package com.meta.other;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum_Bruteforce(int[] nums, int goal) {
        int res = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end < nums.length; ++end) {
                sum += nums[end];
                if (sum == goal)
                    ++res;
            }
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0; // финальный результат
        Map<Integer, Integer> map = new HashMap<>(); // карта предыдущих сумм до текущего числа
        int sum = 0;
        map.put(sum, 1); // засовываем 0
        for(int num: nums){
            sum += num;
            if(map.containsKey(sum - goal)) // если среди предыдущих значений есть сумма - цель
                result += map.get(sum - goal);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//
//A subarray is a contiguous part of the array.