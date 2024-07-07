package com.Amazon;

import java.util.Arrays;

public class ValidTriangleNumber {

    private boolean isTriangle(int a, int b, int c) {
        return a < b + c && a + b > c && a + c > b;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int result = 0;
        for (int i = size - 1; i >= 0; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    result += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
//Given an integer array nums, return the number
// of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.