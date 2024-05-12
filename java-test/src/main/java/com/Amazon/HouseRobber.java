package com.Amazon;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    static public int rob(int[] nums) {
        int max_robbed = 0;
        int previous_robbed = 0;
        for (int num : nums) {
            int temp = max_robbed;
            max_robbed = Math.max(previous_robbed + num, max_robbed);
            previous_robbed = temp;
        }
        return max_robbed;
    }
}
//You are a professional robber planning to rob
// houses along a street. Each house has a certain
// amount of money stashed, the only constraint stopping
// you from robbing each of them is that adjacent houses
// have security systems connected and it will automatically
// contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of
// each house, return the maximum amount of money you can rob tonight without alerting the police.