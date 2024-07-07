package com.Amazon;

public class DeleteNodeinaLinkedList {
    private class ListNode{
        ListNode next;
        int val;
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
