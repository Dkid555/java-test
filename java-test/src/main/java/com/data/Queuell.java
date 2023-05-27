package com.data;

import java.util.LinkedList;

public class Queuell {
    LinkedList<Integer> lst = new LinkedList<>();

    public void add(int i) {
        lst.add(i);
    }

    @Override
    public String toString() {
        return lst.toString();
    }

    public int pop() {
        return lst.removeFirst();
    }

    public int size() {
        return lst.size();
    }

    public int peek() {
        return lst.peek();
    }

    public static void main(String[] args) {
        Queuell queue = new Queuell();
        for (int i = 0; i < 10; i++) queue.add(i);
        //queue.add(10);
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(queue);
        QQ n1 = new QQ();
        n1.push(1);
        n1.push(2);
        //ystem.out.println();
        n1.disp();
        System.out.println(n1.toString());

    }
}

class Node {
    int value;
    Node next;

    public Node() {
        this.value = 0;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return (value + " " + next).replaceAll(" null", "");
    }

}

class QQ {
    Node node = new Node();

    public void push(int i) {
        Node n1 = new Node(i, node);
        node = n1;
    }

    //@Override
    public void disp() {
        String s;
        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;

        }
        //return node.value + " "+ next;
    }

    public String toString() {
        return node.toString();
    }
}
