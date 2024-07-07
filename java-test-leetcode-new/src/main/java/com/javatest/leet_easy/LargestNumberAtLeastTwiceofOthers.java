package com.javatest.leet_easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestNumberAtLeastTwiceofOthers {

    public static int dominantIndex(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            queue.add(nums[i]);
        }
        int last = queue.poll();
        int prevLast = queue.poll();
        return last >= prevLast * 2 ? map.get(last) : -1;
    }

    public static int dominantIndex2(int[] nums) {
        int resIndex = -1;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                if (max != Integer.MIN_VALUE) secondMax = max;
                max = nums[i];
                resIndex = i;
            } else {
                secondMax = Math.max(secondMax, nums[i]);
            }
        }
        return max >= secondMax * 2 ? resIndex : -1;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex2(new int[]{0, 0, 3, 2}));
    }
}
