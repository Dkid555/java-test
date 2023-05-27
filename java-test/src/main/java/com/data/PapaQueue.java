package com.data;

class Node2 {
    int value;
    Node2 next;

    public Node2(int i, Node2 next) {
        this.value = i;
        this.next = next;
    }
}

public class PapaQueue {
    Node2 head;

    public void push(int i) {
        if (head == null) {
            Node2 n1 = new Node2(i, null);
            head = n1;
        } else {
            Node2 n2 = head;
            Node2 n1 = new Node2(i, null);
            while (n2.next != null) n2 = n2.next;
            n2.next = n1;
        }

    }

    public int pop() {
        if (head == null) {
            System.out.println("Empty Queue");
            return 0;
        }
        ;
        int i = head.value;
        head = head.next;
        return i;
    }

    @Override
    public String toString() {
        Node2 n = head;
        String s = null;
        while (n != null) {
            s = s + n.value + " ";
            n = n.next;
        }
        return s.replaceAll("null", "");
    }

    public int peek() {
        return 0;
    }

    public static void main(String[] args) {
        PapaQueue queue = new PapaQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.toString());
    }
}
