package com.javatest.meta.other;

import java.util.*;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int num : nums){
            if(visited.contains(num)){
                result.add(num);
            }
            visited.add(num);
        }
        return new ArrayList<>(result);
    }
    public List<Integer> findDuplicates2(int[] nums) {
        int[] duplicates = new int[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        int max_num = Integer.MIN_VALUE;
        for(int num : nums){
            ++duplicates[num];
            max_num = Math.max(max_num, num);
        }
        for(int i = 0; i <= max_num; ++i){
            if(duplicates[i] > 1)
                result.add(i);
        }
        return result;
    }
}
