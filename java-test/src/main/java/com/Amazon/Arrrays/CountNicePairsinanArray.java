package com.Amazon.Arrrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNicePairsinanArray {
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{42,11,1,97}));
    }
    private static int reverse (int val){
        var rev = 0;
        while (val > 0) {
            rev = (rev * 10) + (val % 10);
            val /= 10;
        }
        return rev;
    }
    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums){
            int diff = num - reverse(num);
            int prev_ = map.getOrDefault(diff, 0);
            count = (count + prev_) % 1000000007;
            map.put(diff, prev_ + 1);
        }
        return count;
    }
    //You are given an array nums that consists of
    // non-negative integers. Let us define rev(x) as
    // the reverse of the non-negative integer x.
    // For example, rev(123) = 321, and rev(120) = 21.
    // A pair of indices (i, j) is nice if it satisfies all of the following conditions:
    //
    //0 <= i < j < nums.length
    //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
    //Return the number of nice pairs of indices.
    // Since that number can be too large, return it modulo 109 + 7.
    //
    //
}
