package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;


//The next greater element of some element x in an array
// is the first greater element that is to the right of x in the same array.
//
//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//
//For each 0 <= i < nums1.length, find the index j such that
// nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
// If there is no next greater element, then the answer for this query is -1.
//
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
//        System.out.println(map);
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})).boxed().collect(Collectors.toList()));
    }
}
