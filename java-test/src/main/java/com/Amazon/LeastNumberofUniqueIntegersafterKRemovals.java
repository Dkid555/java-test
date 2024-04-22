package com.Amazon;

import java.util.*;

public class LeastNumberofUniqueIntegersafterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> elements = new ArrayList<>(map.entrySet());

        elements.sort(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : elements) {
            if (entry.getValue() <= k) {
                k -= entry.getValue();
                map.remove(entry.getKey());
            } else {
                break;
            }
        }
        return map.size();
    }
}
