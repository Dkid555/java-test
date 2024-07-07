package com.javatest.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeMaximumPairSuminArray {
    public int minPairSum(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            min.offer(num);
            max.offer(num);
        }
        int maxSum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int currSum = min.poll() + max.poll();
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    //Better
    public int minPairSum2(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1;
        int left = 0;
        int max = 0;
        while (left < right) {
            int current = nums[left++] + nums[right--];
            max = Math.max(max, current);
        }
        return max;
    }
}
