package com.leetcode;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] sort_indexes = new int[10001];
        for (int num : nums){
            num = Math.abs(num);
            max = Math.max(max, num);
            ++sort_indexes[num];
        }
        int index = 0;
        for(int i = 0; i <= max; ++i){
            if(sort_indexes[i] != 0){
                while (sort_indexes[i] != 0){
                    nums[index++] = i * i;
                    --sort_indexes[i];
                }
            }
        }
        return nums;

    }
}
