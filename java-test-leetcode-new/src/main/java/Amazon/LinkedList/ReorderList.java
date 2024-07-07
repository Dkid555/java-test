package com.Amazon.LinkedList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
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
            StringBuilder result = new StringBuilder();
            while (temp != null){
                result.append(temp.val).append(" -> ");
                temp = temp.next;
            }
            return result.substring(0, result.length() - 4);
        }
    }

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
