package com.javatest.leet_easy;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == 1){
//                int sum = 0;
//                while (nums[i] == 1){
//                    i++;
//                    sum++;
//                    if(i == nums.length) break;
//                }
//                max = Math.max(max, sum);
//            }
//        }
//        return Math.max(max, 0);

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            } else {
                max = Math.max(sum, max);
                sum = 0;
            }
        }
//        max = Math.max(sum, max);
        return Math.max(sum, max);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
//Given a binary array nums, return the maximum number of consecutive 1's in the array.