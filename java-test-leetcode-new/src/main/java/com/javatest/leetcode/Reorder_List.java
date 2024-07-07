package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Reorder_List {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp);
            temp = temp.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end){
            list.get(start).next = list.get(end);
            if(start + 1 < end){
                list.get(end).next = list.get(start+1);
            }
            ++start;
            --end;
        }
        list.get(start).next = null;



    }
}
