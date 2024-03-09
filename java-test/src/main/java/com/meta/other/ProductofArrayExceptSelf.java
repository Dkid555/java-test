package com.meta.other;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) { // слева
            ans[i] *= curr; // по сути произведение всей левой части до текущей
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) { // справа
            ans[i] *= curr; // произведение всей левой части до текущей
            curr *= nums[i];
        }
        return ans;
    }
}
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.