package com.Amazon.LinkedList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLinkedList {
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        list.add(0,null);
        for (int i = list.size() - 1; i  >= 1; --i)
            list.get(i).next = list.get(i-1);
        return list.get(list.size() - 1);
    }
}
