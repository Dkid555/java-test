package com.leet_easy;

// Remove elements from a list that above given value

public class RemoveLists {

    static ListNode full(ListNode head, int x) {
        ListNode temp = head;

        // while loop takes care if head node value greater
        // than x.
        while (temp != null && temp.val > x) {
            temp = temp.next;
            head = temp; // new head.
        }
        temp = head;
        ListNode prev = temp;

        // nodes other than head having value greater than x
        while (temp != null) {
            while (temp != null && temp.val <= x) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                return head;
            }
            // if there is a node in middle which has
            // greater value, we point the node to the next
            // node.
            prev.next = temp.next;
            // update temp for next iteration of loop.
            temp = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(10);
        n1.append(5);
        n1.append(6);
        n1.append(15);
        n1.append(20);
        ListNode n2 = full(n1, 14);
        System.out.println(n2);
    }

}
