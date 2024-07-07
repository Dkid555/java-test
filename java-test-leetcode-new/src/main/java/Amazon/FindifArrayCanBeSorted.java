package com.Amazon;

public class FindifArrayCanBeSorted {
    // Helper method to check if the number of set bits is equal for two integers
    private static boolean Equal(int a, int b) {
        return Integer.bitCount(a) == Integer.bitCount(b);
    }

    public static boolean canSortArray(int[] nums) {
        // Bubble sort algorithm with an additional check using the Equal helper method
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    if(!Equal(nums[j], nums[j+1]))
                        return false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        // If the loop completes, the array can be sorted, returning true
        return true;
    }
}
