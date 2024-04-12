package com.Amazon.Bit_manipulation;

import org.jetbrains.annotations.NotNull;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ans = nums.length; // 0 - место шде про п
        for (int i = 0; i < nums.length; ++i)
            ans ^= i ^ nums[i];

        return ans;
    }
}
//Given an array nums containing n distinct
// numbers in the range [0, n], return the only number in the range that is missing from the array.