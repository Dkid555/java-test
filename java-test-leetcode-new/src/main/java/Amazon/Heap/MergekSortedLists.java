package com.Amazon.Heap;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergekSortedLists {
    @AllArgsConstructor
    @NoArgsConstructor
    private class ListNode{
        int val;
        ListNode next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList<>();
        for (ListNode temp : lists){
            while (temp != null){
                list.add(temp);
                temp = temp.next;
            }
        }
        list.sort(Comparator.comparing(a -> a.val));
        list.add(null);

        for (int i = 0; i < list.size() - 1; ++i){
            list.get(i).next = list.get(i+1);
        }
        return list.get(0);
    }
}
//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.