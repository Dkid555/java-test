package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    static int singleNumber(int[] nums) {
        Map<Integer, Integer> num = new HashMap();
        for (int x : nums) {
            if (num.containsKey(x)) num.put(x, num.get(x) + 1);
            else num.put(x, 1);
        }
        return get_value(num, 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));

        System.out.println(singleNum(nums));
    }

    static int get_value(Map<Integer, Integer> input_map, Integer Value) {
        for (Map.Entry<Integer, Integer> entry : input_map.entrySet()) {
            if (entry.getValue() == Value) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //    Fastest one:
    static int singleNum(int[] nums) {
        int result = 0; // any value n XOR 0 -> n
        for (int num : nums) {
            result = result ^ num; // XOR operation
            // the binary representation of same integers will cancel out, so 1 = 01 XOR 01 -> 00
            // at the end, ure left w/ the binary representations of the no. that only appears once
        }
        return result;
    }
}

