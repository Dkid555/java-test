package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            list.add(temp.val);
            temp = temp.next;
        }

        int[] result = new int[size];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek();
            }

            stack.push(list.get(i));
        }
        return result;
    }


}
//You are given the head of a linked list with n nodes.
//
//For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
//
//Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.