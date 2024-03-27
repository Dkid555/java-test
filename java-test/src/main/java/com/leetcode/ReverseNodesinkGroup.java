package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseNodesinkGroup {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(reverseKGroup(node, 4));
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int chunks = list.size()/k;
        Stack<ListNode> start_ = new Stack<>();
        int start = 0;
        if(chunks == 0){
            rotate(list, 0, list.size() - 1, start_);
        }else{
            for(int chunk = 1; chunk <= chunks; ++chunk){
                int end = start + k;
                rotate(list, start, end - 1, start_);
                start = end;
            }
        }
        if(!start_.isEmpty() && start_.size() > 1){
            start_.pop();
        }

        return start_.isEmpty() ? null :start_.pop();
    }


    private static void rotate(List<ListNode> list, int start, int end, Stack<ListNode> start_){
        boolean check = true;
        if(start_.isEmpty()){ // засовываем первый эелемент
            start_.add(list.get(end));
            check = false;
        }
        for (int i = end; i >= start + 1; --i){
            list.get(i).next = list.get(i - 1);
        }
        if(list.size() - 1 > end){
            list.get(start).next = list.get(end + 1);
        }else
            list.get(start).next = null;

        if(check){
            ListNode last_prev = start_.pop();
            last_prev.next = list.get(end);
        }
        start_.push(list.get(start));
    }

}
