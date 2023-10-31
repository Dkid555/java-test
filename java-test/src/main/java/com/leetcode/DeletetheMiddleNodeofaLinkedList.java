package com.leetcode;

public class DeletetheMiddleNodeofaLinkedList {
    public static ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
            count++;
        }
        if (count == 0) {
            return null;
        }
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(deleteMiddle(head));
    }
}
//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
//
//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
// where ⌊x⌋ denotes the largest integer less than or equal to x.
//
//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.