package com.javatest.leet_easy;

import java.util.List;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // In case k is larger than the length of the array, take the modulo.

        // Reverse the first n-k elements.
        reverseArray(nums, 0, n - k - 1);

        // Reverse the rest elements.
        reverseArray(nums, n - k, n - 1);

        // Reverse the entire array.
        reverseArray(nums, 0, n - 1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

//    public static void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
//        while (k > 0){
//            shift(list);
//            k--;
//        }
//        for (int i = 0; i < nums.length; i++){
//            nums[i] = list.get(i);
//        }

    public static void shift(List<Integer> list) {
        int last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        list.add(0, last);
    }

    public static void main(String[] args) {
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
