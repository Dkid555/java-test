package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode temp = head;
        List<ListNode> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            list.get(right).next = list.get(left + 1);
            ++left;
            --right;
            if (left == left) {
                list.get(left).next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head);
        //System.out.println();
    }
}
//You are given the head of a singly linked-list. The list can be represented as:
//
//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
//