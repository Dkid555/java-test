package com.leet_easy;


/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    void append(int value) {
        ListNode head = this;
        while (head.next != null) {
            head = head.next;
        }
        ListNode n1 = new ListNode(value);
        head.next = n1;
    }


    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

//    @Override
//    public String toString() {
//        return (val + ", " + next).replaceAll(", null", "");
//    }

}

public class MergeTwoSortedLL {
    public static ListNode mergeTwo(ListNode List1, ListNode List2) {
        if (List1 != null && List2 != null) {
            if (List1.val < List2.val) {
                List1.next = mergeTwo(List1.next, List2);
                return List1;
            } else {
                List2.next = mergeTwo(List1, List2.next);
                return List2;
            }
        }
        if (List1 == null) return List2;
        return List1;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(7);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode q3 = new ListNode(4);
        ListNode q2 = new ListNode(3, q3);
        ListNode q1 = new ListNode(1, q2);
        System.out.println(mergeTwo(n1, q1).toString());
    }

}
