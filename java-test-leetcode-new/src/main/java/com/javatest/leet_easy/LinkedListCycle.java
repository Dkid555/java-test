package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {

    static void cycle(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next.next;
    }

    static boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> cycle = new HashMap<>();
        ListNode temp = head;
        while (temp.next != null) {
            if (cycle.containsKey(temp)) return true;
            cycle.put(temp, temp.val);
            temp = temp.next;
        }
        return false;
    }

    static boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.append(2);
        head.append(0);
        head.append(-4);
        cycle(head);
        System.out.println(hasCycle2(head));
        System.out.println(hasCycle(head));
    }
}
