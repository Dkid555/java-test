package com.Amazon.Arrrays;

public class SplittheArray {
    public boolean isPossibleToSplit(int[] nums) {
        int[] counter = new int[101];
        for (int num : nums){
            ++counter[num];
            if(counter[num] > 2)
                return false;
        }
        return true;
    }
}
