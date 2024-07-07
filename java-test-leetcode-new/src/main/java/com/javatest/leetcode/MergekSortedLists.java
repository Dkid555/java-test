package com.javatest.leetcode;


/*
class ListNode1{
    int[] value;
    ListNode1 next;
    public ListNode1(int[] value, ListNode1 next){
        this.value = value;
        this.next = next;
    }
    public void Append(int[] val){
        ListNode1 list = this;
        while (list.next != null) list = list.next;
        list.next = new ListNode1(val, null);

    }


}*//*
public class MergekSortedLists {

    public static void main(String[] args) {
        LinkedList lists = new LinkedList();
        LinkedList dummyHead = new LinkedList();

        // try pq
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            LinkedList cp = lists[i];


            while (cp != null) {
                pq.add(cp);
                ListNode next = cp.next;
                cp.next = null;
                cp = next;
            }
        }

        ListNode dp = dummyHead;
        while (pq.isEmpty() == false) {
            dp.next = pq.poll();
            dp = dp.next;
        }

        return dummyHead.next;
    }

}
    }

}*/
