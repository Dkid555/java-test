package com.javatest.leetcode;

import java.util.PriorityQueue;

public class SortanArray {
    static int Partion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int temp;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void quicks(int[] arr, int low, int high) {
        if (low < high) {
            int pi = Partion(arr, low, high);
            quicks(arr, low, pi - 1);
            quicks(arr, pi + 1, high);
        }
    }

    public int[] sortArray(int[] nums) {
        quicks(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] sortArray2(int[] nums) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int n : nums)
            pQ.add(n);
        for (int i = 0; i < nums.length; i++)
            nums[i] = pQ.poll();
        return nums;
    }
}
