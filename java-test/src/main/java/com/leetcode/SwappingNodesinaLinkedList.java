package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesinaLinkedList {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        List<ListNode> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int lenght = list.size();
        int value = list.get(k - 1).val;
        list.get(k - 1).val = list.get(lenght - k).val;
        list.get(lenght - k).val = value;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(swapNodes(head, 3));

    }
}
//You are given the head of a linked list, and an integer k.
//
//Return the head of the linked list after swapping the values of the kth node from the beginning and the kth
// node from the end (the list is 1-indexed).