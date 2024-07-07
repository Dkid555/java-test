package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingtoGivenPivot {


    public static int[] pivotArray2(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                right.add(num);
            } else if (num < pivot) {
                left.add(num);
            } else
                mid.add(num);
        }
        left.addAll(mid);
        left.addAll(right);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left.get(i);
        }
        return res;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                right.add(num);
            } else if (num < pivot) {
                left.add(num);
            } else
                mid.add(num);
        }
        left.addAll(mid);
        left.addAll(right);
        return left.stream().mapToInt(i -> i).toArray();
    }

    public int[] pivotArray3(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            }
            if (nums[n - i - 1] > pivot) {
                res[right--] = nums[n - i - 1];
            }
        }
        while (left <= right) {
            res[left++] = pivot;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray2(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }
}
