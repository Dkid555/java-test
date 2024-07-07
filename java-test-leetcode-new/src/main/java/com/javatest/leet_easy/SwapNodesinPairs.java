package com.javatest.leet_easy;

public class SwapNodesinPairs {

    static ListNode SwapPair(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode current = temp;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        System.out.println(SwapPair(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
    }
}
