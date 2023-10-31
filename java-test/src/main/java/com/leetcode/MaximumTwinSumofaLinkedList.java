package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumofaLinkedList {
    public int pairSum(ListNode head) {
        ListNode temp = head;
        List<ListNode> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int sum = Integer.MIN_VALUE;
        int leftStart = list.size() / 2 - 1;
        int rightStart = list.size() / 2;
        while (leftStart >= 0 && rightStart < list.size()) {
            sum = Math.max(list.get(leftStart--).val + list.get(rightStart++).val, sum);
        }
        return sum;
    }
}
//In a linked list of size n, where n is even, the ith node (0-indexed) of
// the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
//
//For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
//The twin sum is defined as the sum of a node and its twin.
//
//Given the head of a linked list with even length, return the maximum twin sum of the linked list.