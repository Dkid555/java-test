package com.javatest.leetcode;

public class DistributeCandiestoPeople {
    public static int[] distributeCandies(int totalCandies, int num_people) {
        int[] nums = new int[num_people];
        int i = 0;
        int givenCandies = 0;
        int candies = 1;
        while (true) {
            if (i == num_people) i = 0;
            if (givenCandies + candies <= totalCandies) {
                nums[i++] += candies++;
                givenCandies += candies - 1;
            } else {
                nums[i] += totalCandies - givenCandies;
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(7, 4));
    }
}
