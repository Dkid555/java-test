package com.javatest.meta.other;

import java.util.Arrays;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        // Find the maximum element in the array
        int max = Arrays.stream(nums).max().getAsInt(); // Max function to find the maximum value

        long ans = 0; // Initialize a variable to store the answer
        int l = 0, r = 0, n = nums.length; // Initialize variables for left and right pointers, and the length of the array

        // Iterate through the array using sliding window technique
        while (r < n) { // Move the right pointer till the end of the array
            k -= nums[r] == max ? 1 : 0; // If the current element is equal to the maximum element, decrement k
            r++; // Move the right pointer

            // Shrink the window if k becomes zero
            while (k == 0) { // If k becomes zero, meaning we have found a subarray satisfying the condition
                k += nums[l] == max ? 1 : 0; // If the leftmost element is the maximum element, increment k
                l++; // Move the left pointer to shrink the window
            }

            ans += l; // Increment the answer by the length of the current valid subarray
        }

        return ans; // Return the final answer
    }
}
