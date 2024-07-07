package com.Amazon.Arrrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofOperationstoMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(val < 2) return -1;
            count += val/3;
            if(val % 3 != 0)
                ++count;

        }
        return count;
    }
}
//