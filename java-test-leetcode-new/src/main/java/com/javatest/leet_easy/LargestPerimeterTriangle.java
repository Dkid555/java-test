package com.javatest.leet_easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        if (nums.length < 3)
            return 0;
//        int max = 0;
//        for (int side1 = 0; side1 < nums.length; side1++)
//            for (int side2 = side1 + 1; side2 < nums.length; side2++)
//                for (int side3 = side2 + 1; side3 < nums.length; side3++){
//                    if(nums[side2] < nums[side1] + nums[side3] && nums[side1] < nums[side2] + nums[side3] && nums[side3] < nums[side2] + nums[side1])
//                        max = Math.max(nums[side1] + nums[side2] + nums[side3], max);
//                }
//        return max;


        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int side1 = i;
            int side2 = i - 1;
            int side3 = i - 2;
            if (nums[side2] < nums[side1] + nums[side3] && nums[side1] < nums[side2] + nums[side3] && nums[side3] < nums[side2] + nums[side1])
                return nums[side1] + nums[side2] + nums[side3];
        }
        return 0;
    }
}
