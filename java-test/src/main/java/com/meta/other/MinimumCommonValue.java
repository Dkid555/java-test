package com.meta.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int min = -1;

        for (int num : set1) {
            if (set2.contains(num)) {
                if (min == -1)
                    min = num;
                else
                    min = Math.min(min, num);
            }
        }
        return min;

    }

    // they are sorted
    public int getCommon2(int[] nums1, int[] nums2) {
//        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num))
                return num;
        }
        return -1;
    }
}
