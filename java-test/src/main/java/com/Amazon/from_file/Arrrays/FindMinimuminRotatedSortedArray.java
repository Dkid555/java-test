package com.Amazon.from_file.Arrrays;

public class FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= nums[end]) end = mid;
            else start = mid + 1;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
