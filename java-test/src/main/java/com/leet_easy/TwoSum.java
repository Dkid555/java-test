package com.leet_easy;


import java.util.HashMap;
import java.util.Map;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/
public class TwoSum {

    static int[] helper(int[] nums, int target) {
        int[] fin = new int[2];
        Map<Integer, Integer> help = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (help.containsKey(diff)) {
                fin[0] = help.get(diff);
                fin[1] = i;
                return fin;
//                break;
            }
            help.put(nums[i], i);
        }
        System.out.println("No such pair");
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 34, 5, 6, 7};
        int target = 9;
        int[] fin = helper(nums, target);
        if (fin != null)
            System.out.println("Your indexes: " + fin[0] + ", " + fin[1]);

    }
}
