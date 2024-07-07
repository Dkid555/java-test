package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int size = nums.length;
        if (size % 3 != 0)
            return new int[0][0]; // Return an empty 2D array if size is not divisible by 3
        Arrays.sort(nums);
        int[][] result = new int[size / 3][3]; // 2D array to hold the result
        int index = 0; // Index for result array
        for (int i = 0; i < size; i += 3) {
            if (i + 2 < size && nums[i + 2] - nums[i] <= k) {
                result[index] = new int[]{nums[i], nums[i + 1], nums[i + 2]}; // Assign subarray to result
                index++; // Move to the next row in result array
            } else {
                return new int[0][0]; // Return an empty 2D array if condition fails
            }
        }
        return result;
    }

}
