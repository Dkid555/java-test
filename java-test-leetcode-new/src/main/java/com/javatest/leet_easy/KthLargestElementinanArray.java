package com.javatest.leet_easy;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
//        int max = Integer.MIN_VALUE;
//        List<Integer> list = new ArrayList<>();
//        List<Integer> other = new ArrayList<>();
//        for (int val : nums){
//            if(val >= max){
//                list.add(val);
//                max = val;
//            }
//            else other.add(val);
//        }
//        if(k <= list.size()) return list.get(list.size() - k);
//        return other.stream().sorted().toList().get(other.size() + list.size() - k);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : nums) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{-1, 2, 0}, 2));
    }
}
//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Can you solve it without sorting?