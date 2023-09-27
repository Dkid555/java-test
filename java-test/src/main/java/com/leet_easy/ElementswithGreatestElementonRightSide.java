package com.leet_easy;

public class ElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int[] nums = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            nums[i] = max;
            max = Math.max(arr[i], max);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
    }
}
//Given an array arr, replace every element in that array with the greatest
// element among the elements to its right, and replace the last element with -1.
//
//After doing so, return the array.