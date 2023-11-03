package com.leetcode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head;
        ListNode numInsert, prev;

        while (curr.next != null) {
            if (curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                numInsert = curr.next; // numInsert -> the smaller value which needs to be its correct position
                prev = dummy; // prev -> this indicate the position where numInsert will be inserted
                while (prev.next.val < numInsert.val) {
                    prev = prev.next;
                }
                curr.next = numInsert.next;
                numInsert.next = prev.next;
                prev.next = numInsert;
            }
        }
        return dummy.next;

    }
}
//Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
//
//The steps of the insertion sort algorithm:
//
//Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
//At each iteration, insertion sort removes one element from the input data, finds the location it belongs
// within the sorted list and inserts it there.
//It repeats until no input elements remain.
//The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially
// contains only the first element in the list. One element (red) is removed from the input data and inserted in-place
// into the sorted list with each iteration.
