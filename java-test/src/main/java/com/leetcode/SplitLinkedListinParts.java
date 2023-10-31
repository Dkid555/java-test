package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        List<ListNode> parts = new ArrayList<>();

        while (current != null) {
            length++;
            current = current.next;
        }

        int base_size = length / k, extra = length % k;
        current = head;

        for (int i = 0; i < k; i++) {
            int part_size = base_size + (extra > 0 ? 1 : 0);
            ListNode part_head = null, part_tail = null;

            for (int j = 0; j < part_size; j++) {
                if (part_head == null) {
                    part_head = part_tail = current;
                } else {
                    part_tail.next = current;
                    part_tail = part_tail.next;
                }

                if (current != null) {
                    current = current.next;
                }
            }

            if (part_tail != null) {
                part_tail.next = null;
            }

            parts.add(part_head);
            extra = Math.max(extra - 1, 0);
        }

        return parts.toArray(new ListNode[0]);
    }
}
//Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
//
//The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
// This may lead to some parts being null.
//
//The parts should be in the order of occurrence in the input list, and parts occurring earlier should always
// have a size greater than or equal to parts occurring later.
//
//Return an array of the k parts.