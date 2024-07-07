package com.javatest.leet_easy;

public class MergeNodesinBetweenZeros {
    public static ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        head = head.next;
        while (temp.next != null) {
            if (temp.val != 0) {
                ListNode begin = temp;
                while (temp.next != null && temp.val != 0) {
                    temp = temp.next;
                    begin.val += temp.val;
                }
                begin.next = temp.next;
            } else
                temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(0))))))));
        System.out.println(mergeNodes(head2));
    }
}
//You are given the head of a linked list, which contains a series of integers separated by 0's.
// The beginning and end of the linked list will have Node.val == 0.
//
//For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is
// the sum of all the merged nodes. The modified list should not contain any 0's.
//
//Return the head of the modified linked list.