package com.javatest.leet_easy;

import java.util.Arrays;

public class RemoveNodesFromLinkedList {
    public static ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        Arrays.asList(2, 13, 3, 8).forEach(node::append);
        System.out.println(node.toString());

        System.out.println(removeNodes(node).toString());
    }
}


//You are given the head of a linked list.
//
//Remove every node which has a node with
// a strictly greater value anywhere to the right side of it.
//
//Return the head of the modified linked list.