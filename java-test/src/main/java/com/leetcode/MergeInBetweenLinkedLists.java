package com.leetcode;

public class MergeInBetweenLinkedLists {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1;
        ListNode temp1 = list1;
        ListNode temp2;

        for (int i = 0; i < b; i++) {
            if (i == a - 1)
                temp1 = current;
            current = current.next;
        }
        temp2 = current.next;
        temp1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = temp2;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list2 = new ListNode(100, new ListNode(101, new ListNode(102, new ListNode(103, new ListNode(104)))));

        System.out.println(mergeInBetween(list1, 2, 4, list2));
    }
}
