package com.Amazon;

//import com.leetcode.Node;

import lombok.*;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Mergetwosortedlinkedlists {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
//    @ToString
    private static final class Node{
        int val;
        Node next;
        @Override
        public String toString(){
            String res = " ";
            Node temp = this;
            while (temp != null){
                res += temp.val + ", ";
                temp = temp.next;
            }
            return res;
        }
    }

    public static Node merge_sorted(
            Node head1,
            Node head2) {
        List<Node> list = new ArrayList<>();

        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                list.add(head1);
                head1 = head1.next;
            }
            else{
                list.add(head2);
                head2 = head2.next;
            }
        }
        if(head1 != null){
            head2 = head1;
        }
        while (head2 != null){
            list.add(head2);
            head2 = head2.next;
        }
        for (int i = 0; i < list.size() - 1; ++i){
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;

        return list.get(0);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, new Node(2, new Node(4, new Node(7, new Node(8, null)))));
        Node head2 = new Node(3, new Node(5, new Node(6, null)));
        System.out.println(merge_sorted(head1, head2));


    }
}
