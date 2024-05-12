package com.Amazon;

public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(rob(new
                int[] {1}));
    }
    public static int rob(int[] nums) {
        return nums.length == 1 ? nums[0] : Math.max(rob(nums, 0, nums.length - 1) , rob(nums, 1, nums.length));
    }

    private static int rob(int[] nums, int start, int end){
        int max_robbed = 0;
        int prev_robbed = 0;
        for(int i = start; i < end; ++i){
            int temp = max_robbed;
            max_robbed = Math.max(prev_robbed + nums[i], max_robbed);
            prev_robbed = temp;
        }
        return max_robbed;
    }
}
