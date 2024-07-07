package com.Amazon;

public class DoubleaNumberRepresentedasaLinkedList {

    private static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    int from_prev = 0;
    public ListNode doubleIt(ListNode head) {
        recursive(head);
        if(from_prev != 0){
            ListNode prev = new ListNode(from_prev % 10);
            prev.next = head;
            from_prev /= 10;
            while (from_prev != 0){
                ListNode temp = new ListNode(from_prev % 10);
                temp.next = prev;
                prev = temp;
                from_prev /= 10;
            }
            return prev;
        }
        else
            return head;

    }

    private void recursive(ListNode head) {
        if(head == null)
            return;
        recursive(head.next);

        head.val = head.val * 2 + from_prev;
        from_prev = head.val / 10;
        head.val %= 10;
    }


}
