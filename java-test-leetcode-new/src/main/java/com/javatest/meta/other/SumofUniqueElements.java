package com.javatest.meta.other;

import java.util.HashMap;
import java.util.Map;

public class SumofUniqueElements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1 );
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                sum += entry.getKey();
            }
        }
        return sum;

    }
}
