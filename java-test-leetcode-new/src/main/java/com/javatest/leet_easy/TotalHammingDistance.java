package com.javatest.leet_easy;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                total += Integer.bitCount(nums[i] ^ nums[j]);
        return total;
    }
}
