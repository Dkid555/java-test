package com.leet_easy;

public class MiddleoftheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode fastTwice = head;
        while (fastTwice.next != null && fastTwice.next.next != null) {
            fastTwice = fastTwice.next.next;
            head = head.next;
        }
        return fastTwice.next != null ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        System.out.println(middleNode(listNode).toString());
    }
}
//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.