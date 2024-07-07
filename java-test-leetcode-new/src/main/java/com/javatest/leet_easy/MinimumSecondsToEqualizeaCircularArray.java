package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumSecondsToEqualizeaCircularArray {
    public static int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.size();

        for (int i = 0; i < 2 * n; i++) {
            int current = nums.get(i % n);
            if (map.containsKey(current) && map.get(current)[0] != i) {
                int maxDist = i - map.get(current)[0];
                if (map.get(current)[0] > i)
                    maxDist = n + map.get(current)[0] - i;

                // found larger distance
                if (map.get(current)[1] == 0 || maxDist > map.get(current)[1]) {
                    int[] temp = map.get(current);
                    temp[1] = maxDist;
                    map.put(current, temp);
                }
            }
            int[] temp2 = map.getOrDefault(current, new int[2]);
            temp2[0] = i;
            map.put(current, temp2);
        }

        int res = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            // 3 -> 1, 2 -> 1
            res = Math.min(res, map.get(i)[1] / 2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumSeconds(Arrays.asList(1, 2, 1, 2)));
    }
}
