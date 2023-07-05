package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArrayISequal {

    //

    public static int find(int[] numbers, int key) {
        int answer = 0;
        for (int start = 0; start < numbers.length; start++) {
            for (int end = start; end < numbers.length; end++) {
                int sub_array = 0;
                for (int k = start; k < end + 1; k++) {
                    sub_array += numbers[k];
                }
                if (sub_array == key)
                    answer += 1;
            }
        }

        return answer;
    }

    // O(n^2)
    public static int find_better(int[] numbers, int key) {
        int answer = 0;
        for (int start = 0; start < numbers.length; start++) {
            int subarray = 0;
            for (int run = start; run < numbers.length; run++) {
                subarray += numbers[run];
                if (subarray == key)
                    answer++;
            }
        }
        return answer;
    }


    //    best solution O(n)
    public static int find_best(int[] numbers, int key) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (map.containsKey(sum - key)) {
                answer += map.get(sum - key);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(find_best(new int[]{1, 2, 3, 4, 5, 6, 7, 10, -5}, 10));
    }
}
