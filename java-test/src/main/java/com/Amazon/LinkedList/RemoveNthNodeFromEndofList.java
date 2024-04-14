package com.Amazon.LinkedList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveNthNodeFromEndofList {

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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int to_remove = list.size() - n;
        if(to_remove < list.size() - 1 && to_remove > 0){
            list.get(to_remove - 1).next = list.get(to_remove + 1);
        }else if (to_remove == 0){
            if(list.size() > 1)
                return list.get(1);
            else
                return null;
        } else if (to_remove == list.size() - 1) {
            list.get(to_remove - 1).next = null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        removeNthFromEnd(head, 2);
        System.out.println(removeNthFromEnd(head, 2));
    }

}
