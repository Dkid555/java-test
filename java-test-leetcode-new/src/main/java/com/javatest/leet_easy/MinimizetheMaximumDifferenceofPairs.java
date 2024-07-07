package com.javatest.leet_easy;

import java.util.Arrays;

public class MinimizetheMaximumDifferenceofPairs {
    //    public static int minimizeMax(int[] nums, int p) {
//        Arrays.sort(nums);
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < p*2; i+=2)
//            max = Math.max(nums[i+1] - nums[i], max);
//        return max;
//    }
    public int check(int[] nums, int diff, int p) {
        int n = nums.length;
        // Go greedily
        for (int i = 0; i < n - 1; i++) {
            // If difference between two elements is less than diff
            if (Math.abs(nums[i] - nums[i + 1]) <= diff) {
                // make this a pair and go to nums[i + 2], nums[i + 3] for comparison
                p--;
                i++;
            }
            // if all pairs are chosen
            if (p == 0) {
                break;
            }
        }
        // if all pairs are picked, then diff could be an answer
        return p == 0 ? 1 : 0;
    }

    public int minimizeMax(int[] nums, int p) {

        // We are finding the minimum of maximums - Hint for Binary Search
        int n = nums.length;
        // Order of array elements don't matter. So, sort the array
        Arrays.sort(nums);

        // The range in which answer could lie is (0, nums[n - 1] - nums[0])
        int left = 0, right = nums[n - 1] - nums[0], res = 0;

        // Same BS on Answer template
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, p) == 1) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
