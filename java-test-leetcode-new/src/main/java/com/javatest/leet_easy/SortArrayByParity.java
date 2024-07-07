package com.javatest.leet_easy;

import java.util.Arrays;

public class SortArrayByParity {
    // one line nLogn
    public static int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] sortArrayByParity2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 0) {
                left++;
            } else {
                //swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 2, 4, 1})));
    }
}
