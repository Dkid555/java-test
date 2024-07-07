package com.Amazon;

import java.util.HashMap;
import java.util.Map;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    private static class Positive_Negative{
        private boolean positive = false;
        private boolean negative = false;
    }
    public static int findMaxK(int[] nums) {
        Map<Integer, Positive_Negative> map = new HashMap<>();
        int max = -1;
        for (int num : nums){
            int abs = Math.abs(num);
            map.putIfAbsent(abs, new Positive_Negative());
            if(num < 0)
                map.get(abs).negative = true;
            else
                map.get(abs).positive = true;

            if(map.get(abs).negative && map.get(abs).positive)
                max = Math.max(abs, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1,2,-3,3}));
    }
}
