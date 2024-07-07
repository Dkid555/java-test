package com.javatest.meta.other;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                list.add(num);
                set1.remove(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


}
