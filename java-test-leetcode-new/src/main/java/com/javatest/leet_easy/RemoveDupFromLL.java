package com.javatest.leet_easy;

public class RemoveDupFromLL {

    public static ListNode removeDuplic(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.append(1);
        head.append(2);
        System.out.println(head);
        removeDuplic(head);
        System.out.println(head);
    }
}
