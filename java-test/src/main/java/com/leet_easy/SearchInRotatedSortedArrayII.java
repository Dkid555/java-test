package com.leet_easy;

public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
//        int pivotIndex = 1;
//        for(;pivotIndex < nums.length; pivotIndex++){
//            if(nums[pivotIndex - 1] >nums[pivotIndex]){
//                break;
//            }
//        }
//        int max = pivotIndex - 1;
//        int min = pivotIndex;
//        while(max < min){
//            int mid = min + Math.abs(max - min) / 2;
//            if(nums[mid] == target)
//                return true;
//            if(nums[mid] > target)
//                max = mid - 1;
//            else min = mid + 1 < nums.length ? mid + 1: 0;
//        }
//        return false;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;

            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 7, 0, 1, 2}, 5));
    }
}
//There is an integer array nums sorted in non-decreasing order
// (not necessarily with distinct values).
//
//Before being passed to your function, nums is rotated at an unknown pivot
// index k (0 <= k < nums.length) such that the resulting array is
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
//
//Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
//
//You must decrease the overall operation steps as much as possible.