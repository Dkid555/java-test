package Amazon.LinkedList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

public class LinkedListCycle {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @RequiredArgsConstructor
    private static class ListNode {
        @NotNull int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some
// node in the list that can be reached again by
// continuously following the next pointer. Internally,
// pos is used to denote the index of the node that tail's next
// pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.