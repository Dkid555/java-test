package com.leet_easy;

import java.util.Arrays;

///Suppose an array of length n sorted in ascending order
// is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1
// time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//You must write an algorithm that runs in O(log n) time.

//Suppose an array of length n sorted in ascending order
// is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
//
//[4,5,6,7,0,1,4] if it was rotated 4 times.
//[0,1,4,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
//
//You must decrease the overall operation steps as much as possible.

public class FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] <= nums[end]) end = mid;
            else begin = mid + 1;
        }
        return nums[begin];
    }

    public static int findMinWithDupl(int[] nums) {
        int begin = 0;
        int[] res = Arrays.stream(nums).distinct().toArray();
        int end = res.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (res[mid] <= res[end]) end = mid;
            else begin = mid + 1;
        }
        return res[begin];
    }

    public static int findMinWithDupl2(int[] nums) {
        int begin = 0, end = nums.length - 1;
        int mid = 0;
        int value = Integer.MAX_VALUE;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            value = Math.min(value, nums[mid]);
            if (nums[begin] >= nums[mid] && nums[mid] > nums[end])
                begin = mid + 1;
            else if (nums[begin] < nums[mid] && nums[mid] <= nums[end])
                end = mid - 1;
            else if (nums[begin] <= nums[mid] && nums[mid] > nums[end])
                begin = mid + 1;
            else {
                int left = mid - 1, right = mid + 1;
                while (left >= 0 && right < nums.length && nums[left] == nums[right]) {
                    left--;
                    right++;
                }
                if (left >= 0 && right < nums.length && nums[left] < nums[right])
                    end = mid - 1;
                else
                    begin = mid + 1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(findMinWithDupl2(new int[]{3, 1, 3}));
    }
}
