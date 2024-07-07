package com.javatest.leet_easy;

public class RemoveDuplicatesfromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        int countBegin = 0;
        ListNode temp = head;
        ListNode previous = head;
        while (temp != null) {
            boolean checkSame = false;
            if (temp.next != null && temp.val == temp.next.val) {
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                if (countBegin == 0)
                    checkSame = true;
            } else {
                countBegin++;
                previous = temp;
                temp = temp.next;
            }
            if (checkSame)
                head = temp;
            else
                previous.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(5)))))))));
        System.out.println(deleteDuplicates(head));
    }
}
//Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list. Return the linked list sorted as well.