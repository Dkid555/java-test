package com.Amazon.LinkedList;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedLists {
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
    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList<>();
        for(ListNode temp : lists){
            while (temp != null) {
                list.add(temp);
                temp = temp.next;
            }
        }
        list.sort(Comparator.comparing((a)->a.val));
        list.add(null);
        for (int i = 0; i < list.size() - 1; ++i)
            list.get(i).next = list.get(i + 1);
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode l3 = new ListNode(4, new ListNode(5, new ListNode(7)));

        System.out.println(mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
