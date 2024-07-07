package com.Amazon;

import java.util.Arrays;

public class HouseRobberIV {
    public static void main(String[] args) {
//        System.out.println(minCapability(new int[]{24,1,55,46,4,61,21,52}, 3));

        System.out.println(minCapability(new int[]{5038,3053,2825,3638,4648,3259,4948,4248,4940,2834,109,5224,5097,4708,2162,3438,4152,4134,551,3961,2294,3961,1327,2395,1002,763,4296,3147,5069,2156,572,1261,4272,4158,5186,2543,5055,4735,2325,1206,1019,1257,5048,1563,3507,4269,5328,173,5007,2392,967,2768,86,3401,3667,4406,4487,876,1530,819,1320,883,1101,5317,2305,89,788,1603,3456,5221,1910,3343,4597}, 28));
    }
    public static int minCapability2(int[] nums, int k) {
        int left = 1,
                right = (int)1e9 + 7,
                nums_len = nums.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < nums_len; ++i)
                if (nums[i] <= mid) {
                    take += 1;
                    i++;
                }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left; //left == right
    }

    public static int minCapability(int[] nums, int k){
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, nums_len = nums.length;
        for(int num : nums){
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        while (left < right){
            int current_max = (left + right) / 2, count_who_less = 0;
            for (int i = 0; i < nums_len; ++i){
                if(nums[i] <= current_max){
                    ++count_who_less; /** добавляем позицию только если она меньше текущего максимума */
                    ++i; /** они не должны быть последовательны */
                }
            }
            if(count_who_less >= k){
                right = current_max; /** если количество домов по доходности меньше чем текущий максимум >= необходимого  */
            }
            else /** если такого количества позиций не существует */
                left = current_max + 1; //
        }
        return left;
    }
    public static int minCapability3(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int max_result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i){
            int[] max = {Integer.MAX_VALUE};
            recursive(nums, i, k - 1, max, dp, nums[i]);
            max_result = Math.min(max[0], max_result);
            System.out.println("current max: " + max_result);
        }
        return max_result;
    }



    public static void recursive(int[] nums,int index, int k, int[] max, int[] dp, int current_max){
        if(index >= nums.length)
            return;
        if(k == 0){
            max[0] = Math.min(current_max, max[0]);
            dp[index] = Math.min(max[0], dp[index]);
        }
        if(dp[index] <= current_max){
            return;
        }
        for(int current_position = index + 2; current_position < nums.length; ++current_position){
            recursive(nums, current_position, k - 1, max, dp, Math.max(current_max, nums[current_position]));
        }
    }
}
//There are several consecutive houses along a street,
// each of which has some money inside. There is also a robber,
// who wants to steal money from the homes,
// but he refuses to steal from adjacent homes.
//
//The capability of the robber is the maximum amount
// of money he steals from one house of all the houses he robbed.
//
//You are given an integer array nums representing how much
// money is stashed in each house. More formally,
// the ith house from the left has nums[i] dollars.
//
//You are also given an integer k, representing the minimum number
// of houses the robber will steal from.
// It is always possible to steal at least k houses.
//
//Return the minimum capability of the robber
// out of all the possible ways to steal at least k houses.