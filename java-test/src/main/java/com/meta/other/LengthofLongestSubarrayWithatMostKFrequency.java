package com.meta.other;

import java.util.*;

public class LengthofLongestSubarrayWithatMostKFrequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int max_len = Integer.MIN_VALUE;

        for (int num : nums){
            queue.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > k){
                while(!queue.isEmpty()) {
                    int temp = queue.poll();
                    map.put(temp, map.getOrDefault(temp, 0) - 1);
                    if(map.get(temp) <= 0)
                        map.remove(temp);
                    if(temp == num && map.get(temp) <= k)
                        break;
                }
            }
            max_len = Math.max(queue.size(), max_len);
        }

        return max_len;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1));
    }
}
