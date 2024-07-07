package com.javatest.leetcode;

import java.util.PriorityQueue;

public class SortList {
    public static ListNode sortList(ListNode head) {
        ListNode temp = head;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (temp != null) {
            queue.add(temp.val);
            temp = temp.next;
        }
        temp = head;
//        Iterator<ListNode> iterator = queue.iterator();
        while (temp != null) {
            temp.val = queue.poll();
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        System.out.println(sortList(head));
    }
}
