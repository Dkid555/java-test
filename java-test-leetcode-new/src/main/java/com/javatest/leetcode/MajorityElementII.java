package com.javatest.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int minAvailable = nums.length / 3;
        if (minAvailable < 1)
            return Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().toList();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        List<Integer> fin = new ArrayList<>();
        for (int num : nums
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > minAvailable && !result.contains(num)) {
                fin.add(num);
                result.add(num);
            }
        }
        return fin;

    }
}


//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.