package com.Amazon.Arrrays;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int current = 1;
        for (int i = 0; i < n; ++i) { // слева
            result[i] *= current; // по сути произведение всей левой части до текущей
            current *= nums[i];
        }
        current = 1;
        for (int i = n - 1; i >= 0; --i) { // справа
            result[i] *= current; // произведение всей левой части до текущей
            current *= nums[i];
        }
        return result;
    }
}
