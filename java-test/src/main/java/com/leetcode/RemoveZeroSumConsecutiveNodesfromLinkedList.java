package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        ListNode temp = new ListNode(0);
        temp.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, temp);


        for (ListNode i = temp; i != null; i = i.next) {
            sum += i.val;
            map.put(sum, i);
        }
        sum = 0;
        for (ListNode i = temp; i != null; i = i.next) {
            sum += i.val;
            i.next = map.get(sum).next;
        }

        return temp.next;
    }
}
//Given the head of a linked list, we repeatedly delete consecutive
// sequences of nodes that sum to 0 until there are no such sequences.
//
//After doing so, return the head of the final linked list.  You may return any such answer.
//
//
//
//(Note that in the examples below, all sequences are serializations of ListNode objects.)