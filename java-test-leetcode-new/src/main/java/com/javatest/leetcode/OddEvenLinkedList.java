package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        List<ListNode> listOdd = new ArrayList<>(); // нечетный
        List<ListNode> listEven = new ArrayList<>(); // четный
        int position = 1;
        while (temp != null) {
            if (position++ % 2 == 0)
                listEven.add(temp);
            else
                listOdd.add(temp);
            temp = temp.next;
        }
        for (int i = 0, j = 0; i < listOdd.size() - 1; i++, j++) {
            listOdd.get(i).next = listOdd.get(i + 1);
            if (j < listEven.size() - 1)
                listEven.get(j).next = listEven.get(j + 1);
        }
        listOdd.get(listOdd.size() - 1).next = listEven.get(0);
        listEven.get(listEven.size() - 1).next = null;
        return head;
    }
}
//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//
//The first node is considered odd, and the second node is even, and so on.
//
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.