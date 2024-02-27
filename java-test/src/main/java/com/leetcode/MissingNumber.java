package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i = 0;
        while(true){
            if(!set.contains(i)){
                return i;
            }
            ++i;
        }
    }
    public int missingNumber2(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; ++i)
            result ^= i ^ nums[i];
        return result;
    }
}
