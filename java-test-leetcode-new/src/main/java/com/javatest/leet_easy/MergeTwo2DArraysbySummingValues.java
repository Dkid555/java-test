package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysbySummingValues {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums1
        ) {
            map.put(num[0], num[1]);
        }
        for (int[] num : nums2
        ) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }
        int[][] result = new int[map.size()][2];

        var itr = map.entrySet().iterator();

//        while(itr.hasNext())
//        {
//            var entry = itr.next();
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//        }

//        int i = 0;
//        map.entrySet().stream().map(entry-> {
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//
//            return null;
//        });

        Map<Integer, Integer> fin = new TreeMap<>(map);

        int i = 0;
//        List<Integer> keys = Arrays.a(map.keySet().stream().sorted());

        for (int key : fin.keySet()
        ) {
            result[i][0] = key;
            result[i++][1] = map.get(key);
        }


        return result;
    }

    public static void main(String[] args) {

        mergeArrays(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 5}}, new int[][]{new int[]{1, 2}, new int[]{2, 3}});
    }
}
