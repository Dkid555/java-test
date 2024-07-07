package com.javatest.leetcode;

public class TestList {

    public static void main(String[] args) {
        Node n2 = new Node();
        Node n1 = new Node(1, n2);

        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }

    }
}
