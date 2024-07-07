package com.javatest.leetcode;

import java.util.Arrays;

public class FindPolygonWiththeLargestPerimeter {
    public long largestPerimeterOLD(int[] nums) {
        Arrays.sort(nums);
        long tempSum = nums[0] + nums[1] + nums[2], sum = -1;
        if (nums[0] + nums[1] > nums[2]) {
            sum = tempSum;
        }
        for (int i = 3; i < nums.length; i++) {
            if (tempSum > nums[i]) {
                tempSum += nums[i];
                sum = tempSum;
            } else {
                tempSum += nums[i];
            }
        }
        return sum;
    }


    public long largestPerimeter(int[] nums) {
        long sumRes;
        long great = findGreatest(nums);
        int count = 0;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (great == nums[i]) {
                    nums[i] = 0;
                    break;
                }
            }
            sumRes = findSumFromArray(nums);
            if (great < sumRes)
                return (sumRes + great);
            great = findGreatest(nums);
            count++;
            if (count == nums.length)
                return -1;
        }
    }

    private long findSumFromArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }

    private long findGreatest(int[] nums) {
        long greatest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            greatest = Math.max(greatest, nums[i]);
        }
        return greatest;
    }
}
//You are given an array of positive integers nums of length n.
//
//A polygon is a closed plane figure that has at least 3 sides.
// The longest side of a polygon is smaller than the sum of its other sides.
//
//Conversely, if you have k (k >= 3) positive real numbers a1, a2, a3, ...,
// ak where a1 <= a2 <= a3 <= ... <= ak and a1 + a2 + a3 + ... + ak-1 > ak,
// then there always exists a polygon with k sides whose lengths are a1, a2, a3, ..., ak.
//
//The perimeter of a polygon is the sum of lengths of its sides.
//
//Return the largest possible perimeter of a polygon whose sides can be formed
// from nums, or -1 if it is not possible to create a polygon.