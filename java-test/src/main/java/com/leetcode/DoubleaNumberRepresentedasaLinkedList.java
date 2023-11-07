package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DoubleaNumberRepresentedasaLinkedList {
    public static ListNode doubleIt(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            temp.val *= 2;
            list.add(temp);
            temp = temp.next;
        }
        int previousDevisor = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            ListNode node = list.get(i);
            if (previousDevisor != 0) {
                node.val += previousDevisor;
                previousDevisor = 0;
            }
            if (node.val / 10 >= 1) {
                previousDevisor = node.val / 10;
                node.val %= 10;
            }
        }
        return previousDevisor != 0 ? new ListNode(previousDevisor, head) : head;
    }

    public static void main(String[] args) {
        System.out.println(doubleIt(new ListNode(9)));
    }


}
