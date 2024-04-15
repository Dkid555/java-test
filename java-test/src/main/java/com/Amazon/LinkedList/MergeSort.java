package com.Amazon.LinkedList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

public class MergeSort {
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

        public ListNode pushNext(int val){
            ListNode temp = this;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new ListNode(val);
            return this;
        }
    }

    private static ListNode mergeLists(ListNode left, ListNode right){
        ListNode result = null;
        if(left == null)
            return right;
        if(right == null)
            return left;
        if(left.val <= right.val){
            result = left;
            result.next = mergeLists(left.next, right);
        }else {
            result = right;
            result.next = mergeLists(left, right.next);
        }
        return result;
    }

    public static ListNode mergeSort(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode middle = getMiddle(node);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = mergeSort(node); // left part sort
        ListNode right = mergeSort(nextToMiddle); // right part sort

        return mergeLists(left, right);
    }
    private static ListNode getMiddle(ListNode node){
        if(node == null)
            return node;
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.pushNext(2).pushNext(10).pushNext(-1).pushNext(7)
                .pushNext(9).pushNext(11).pushNext(14).pushNext(-5).pushNext(18).pushNext(-19);
        System.out.println(node);
        System.out.println("After Sort");
        System.out.println(mergeSort(node));
    }
}
