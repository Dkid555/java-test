package com.javatest.leet_easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
//        if(nums.length == 1)
//            return true;
//        boolean check = nums[0] <= nums[1];
//        for (int i = 2 ; i < nums.length; i++){
//            if(check){
//                if (nums[i] < nums[i-1])
//                    return false;
//            }else {
//                if (nums[i] > nums[i-1])
//                    return false;
//            }
//        }
        return Increase(nums) || Decrease(nums);
    }

    public boolean Increase(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }
        return true;
    }

    public boolean Decrease(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
