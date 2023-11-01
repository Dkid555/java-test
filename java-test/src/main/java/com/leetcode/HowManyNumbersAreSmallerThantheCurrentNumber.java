package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThantheCurrentNumber {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] numsTemp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; ++i)
            nums[i] = map.get(numsTemp[i]);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}
//For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
//For nums[1]=1 does not exist any smaller number than it.
//For nums[2]=2 there exist one smaller number than it (1).
//For nums[3]=2 there exist one smaller number than it (1).
//For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).