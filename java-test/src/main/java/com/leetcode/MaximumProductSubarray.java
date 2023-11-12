package com.leetcode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currentProduct = 1;
        // from left to right
        for (int num : nums) {
            currentProduct *= num;
            maxProduct = Math.max(currentProduct, maxProduct);
            if (currentProduct == 0)
                currentProduct = 1;
        }
        // from right to left
        currentProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentProduct *= nums[i];
            maxProduct = Math.max(currentProduct, maxProduct);
            if (currentProduct == 0)
                currentProduct = 1;
        }
        return maxProduct;
    }
}
