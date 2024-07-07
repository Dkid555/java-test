package com.Amazon;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class RemoveNodesFromLinkedList {

    @AllArgsConstructor
    @NoArgsConstructor
    private static class ListNode{
        int val;
        ListNode next;
    }

//    public static void main(String[] args) {
//        ListNode node = new ListNode(5, new ListNode(3, new ListNode(4, )))
//    }
    public static ListNode removeNodes(ListNode head) {
        if (head == null)
            return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}
