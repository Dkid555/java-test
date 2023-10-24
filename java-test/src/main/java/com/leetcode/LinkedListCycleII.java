package com.leetcode;

public class LinkedListCycleII {
    private static class ListNode {
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }

        private int value;
        private ListNode next;

        @Override
        public String toString() {
            String str = "";
            ListNode temp = this;
            while (temp != null) {
                str += temp.value + " ";
                temp = temp.next;
            }
            return str;
        }

        public int toStringCurrent() {
            return this.value;
        }

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node1).toStringCurrent());
    }

}
