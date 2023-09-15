package com.leet_easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementSize2NArray {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for (int num : nums) {
            if (!vals.add(num))
                return num;
        }

        return -1;
    }

}
//You are given an integer array nums with the following properties:
//
//nums.length == 2 * n.
//nums contains n + 1 unique elements.
//Exactly one element of nums is repeated n times.
//Return the element that is repeated n times.