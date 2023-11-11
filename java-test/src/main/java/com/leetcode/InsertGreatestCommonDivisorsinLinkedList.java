package com.leetcode;

public class InsertGreatestCommonDivisorsinLinkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            ListNode next = temp.next;
            temp.next = new ListNode(gcd(next.val, temp.val), next);
            temp = next;
        }
        return head;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
