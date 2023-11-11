package com.leetcode;

import java.util.Stack;

public class FlattenaMultilevelDoublyLinkedList {

    private static class Node {

        public String toString() {
            return this.val + " " + this.next;
        }

        public Node(int val, Node next, Node child, Node prev) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        int val;
        Node prev;
        Node next;
        Node child;

    }

    public static Node flatten(Node head) {
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            if (temp.child != null) {
                stack.push(temp.next);
                temp.next = temp.child;
                temp.next.prev = temp;
                temp.child = null;
                temp = temp.next;
            } else if (temp.next == null && !stack.empty()) {
                temp.next = stack.pop();
                if (temp.next != null)
                    temp.next.prev = temp;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null, null, null), null, null), null, null), new Node(7, new Node(8, new Node(9, new Node(10, null, null, null), null, null), new Node(11, new Node(12, null, null, null), null, null), null), null, null), null), null, null), null, null);
//        System.out.println(flatten(head));

        Node head2 = new Node(1, null, new Node(2, null, new Node(3, null, null, null), null), null);

        System.out.println(flatten(head2));

    }
}
