package com.Amazon.LinkedList;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @RequiredArgsConstructor
    private static class ListNode {
        @NotNull int val;
        ListNode next;

        @Override
        public String toString() {
            ListNode temp = this;
            String result = "";
            while (temp != null){
                result += temp.val + " -> ";
                temp = temp.next;
            }
            return result.substring(0, result.length() - 4);
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<ListNode> list = new ArrayList<>();
        while (list1 != null && list2 != null){
            while(list1 != null && list1.val <= list2.val){
                list.add(list1);
                list1 = list1.next;
            }
            if(list1 != null)
                while(list2 != null && list2.val <= list1.val){
                    list.add(list2);
                    list2 = list2.next;
                }
        }
        if(list1 != null || list2 != null){
            if(list2 != null)
                list1 = list2;

            while (list1 != null){
                list.add(list1);
                list1 = list1.next;
            }
        }
        list.add(null);
        for (int i = 0; i < list.size() - 1; ++i)
            list.get(i).next = list.get(i+1);
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(1), new ListNode(2)));
    }
}
