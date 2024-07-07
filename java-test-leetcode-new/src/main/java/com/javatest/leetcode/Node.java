package com.javatest.leetcode;

public class Node {
    int val;
    Node next;

    public Node() {
        val = 0;
        next = null;
    }

    public void hash() {
        this.hashCode();
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public void Add(int i) {
        Object n = this;
        while (((Node) n).next != null) {
            n = ((Node) n).next;
        }
        Object n1 = new Node(i, null);
        ((Node) n).next = (Node) n1;
    }

    public Node reverse() {
        Node curr = this;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public String toString() {
        return (this.val + " " + this.next).replaceAll(" null", "");
    }

    // поигрался с объектом)
    public static void main(String[] args) {
        Object n = new Node(1, null);
        ((Node) n).Add(10);
        ((Node) n).Add(15);
        System.out.println(n.toString());
        n = ((Node) n).reverse();
        System.out.println(n);
    }
}
