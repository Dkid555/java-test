package com.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return (val + " " + next).replaceAll(" null", "");

    }

    public void Append(int val) {
        ListNode list = this;
        while (list.next != null) list = list.next;
        list.next = new ListNode(val, null);

    }
}

public class MergeTwoSortLN {
    /*public static void merge(ListNode n, ListNode q){
        if (n.next != null && q.next != null) merge(n.next, q.next);


        if(q.next == null && n.next != null){
            if (q.val > n.val) {
                while (n.next != null){
                    if(q.val <= n.val) break;
                    n = n.next;
                }

            }
            q.next = n.next;
            n.next = q;
            return;
            } else if (n.val > q.val) {
            int temp;
            temp = n.val;
            n.val = q.val;
            q.val = temp;

        }

        else {
            if(n.next != null){
                ListNode z = new ListNode((int)q.val,n.next);
                n.next = z;
            }else n.next = q;
        }

    }*/

    //Beatiful solution
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = merge(list1.next, list2);
                return list1;
            } else {
                list2.next = merge(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) return list2;
        return list1;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(7, null);
        ListNode q5 = new ListNode();
        ListNode n3 = new ListNode(5, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(0, n2);
        ListNode q3 = new ListNode(6, null);
        ListNode q2 = new ListNode(2, q3);
        ListNode q1 = new ListNode(1, q2);
        q1.Append(8);
        System.out.println(n1);
        System.out.println(q1);
        //megre1(n1, q1);
        System.out.println(merge(n1, q1));
    }
}
