package com.leetcode;


//Given an array of integers nums sorted in non-decreasing order,
// find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int low = mid, high = mid;
                while (low >= 0 && nums[low] == target) {
                    low--;
                }
                low++;
                while (high < nums.length && nums[high] == target) {
                    high++;
                }
                high--;
                return new int[]{low, high};
            }


            if (nums[mid] < target)
                left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{6, 7, 7, 8, 8, 10}, 6)));
    }

}
