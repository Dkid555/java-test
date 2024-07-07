package com.javatest.leet_easy;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
//        if(head.val == val) {
//            while (head.val == val) {
//                head = head.next;
//            }
//        }
        ListNode pre = new ListNode(-1, head);
        ListNode dummy = pre;
        while (pre.next != null) {
            if (pre.next.val != val)
                pre = pre.next;
            else
                pre.next = pre.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(7);
//        node.append(7);
//        node.append(7);
//        node.append(7);
//        node.append(7);
//        node.append(7);
//        node.append(7);
//        node.append(7);
//
//        System.out.println(removeElements(node, 7).toString());


        ListNode node2 = new ListNode(1);
        node2.append(2);
        node2.append(3);
        node2.append(4);
        deleteNode(node2.next.next);
        System.out.println(node2.toString());
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
