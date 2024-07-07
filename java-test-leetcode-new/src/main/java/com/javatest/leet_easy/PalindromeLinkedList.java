package com.javatest.leet_easy;

import java.util.Stack;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        while (curr != null) {
            //LIFO last in First out
            if (curr.val != stack.pop()) return false;
            curr = curr.next;
        }
        return true;
    }

    // faster
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // coming to the middle of the list
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) {// filling prev in reverse order
            ListNode curr = slow;
            slow = slow.next;
            curr.next = prev;
            prev = curr;
        }
        while (prev != null) {
            if (prev.val != head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.append(2);
        node1.append(3);
        node1.append(1);
        System.out.println(isPalindrome2(node1));
    }
}
