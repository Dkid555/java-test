package com.javatest.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDuplicateElements {
    public static int countDuplicate(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : numbers) {
            int current = map.getOrDefault(num, 0);
            ++current;
            if (current == 2)
                ++count;
            map.put(num, current);
        }
        return count;
    }
}
