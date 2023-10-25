package com.leet_easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode temp = head;
        List<ListNode> list = new ArrayList<>();
        int start = 1;
        ListNode previous = null;
        ListNode last = null;
        while (temp != null) {
            if (start == left - 1)
                previous = temp;
            else if (start >= left && start <= right) {
                list.add(temp);
            } else if (start == right + 1) {
                last = temp;
                break;
            }
            ++start;
            temp = temp.next;
        }
        for (int i = list.size() - 1; i >= 0; --i) {
            if (i > 0) {
//                list.get(i - 1).next = null;
                list.get(i).next = list.get(i - 1);
            }
        }
        if (previous != null) {
            previous.next = list.get(list.size() - 1);
        }
        list.get(0).next = last;
        return previous == null ? list.get(list.size() - 1) : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(3, new ListNode(5));
        System.out.println(reverseBetween(head2, 1, 2));
    }
}
//Given the head of a singly linked list and two integers left and right where left <= right,
// reverse the nodes of the list from position left to position right, and return the reversed list.