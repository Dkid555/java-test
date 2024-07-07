package com.javatest.leetcode;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int windo_size = 0, start = 0, prod = 1, ans = 0;
        while(start < nums.length) {
            prod *= nums[start++]; // include
            while(windo_size < start && prod >= k) {
                prod /= nums[windo_size++]; // exclude start
            }
            if(prod < k) {
                ans += start-windo_size; // add to answer if it is valid
            }
        }
        return ans;
    }

}
