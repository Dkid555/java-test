package com.javatest.leet_easy;

import java.util.HashSet;
import java.util.Set;

public class BeginOfCycle {

    static void cycle(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next.next;
    }

    static ListNode findBegin(ListNode head) {
        Set<ListNode> cycle = new HashSet<>();
        ListNode temp = head;
        while (temp.next != null) {
            if (cycle.contains(temp)) return temp;
            cycle.add(temp);
            temp = temp.next;
        }
        return null;
    }

    static ListNode findBegin2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (slow.next == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static String displayll(ListNode node) {
        return (node.val + ", " + node.next).replaceAll(", null", "");
    }

    static String display(ListNode node) {
        return ("value: " + node.val + "\nlink: " + node);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(10, new ListNode(7, new ListNode(11, new ListNode(17, new ListNode(22)))))))));
        cycle(node);
        System.out.println(display(findBegin(node)));
        System.out.println(display(findBegin2(node)));

    }
}
