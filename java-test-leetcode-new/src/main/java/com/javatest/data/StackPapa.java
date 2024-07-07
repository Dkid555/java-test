package com.javatest.data;

public class StackPapa {
    Node1 head;
    Node1 tail;


    public void push(int i) {
        Node1 n1 = new Node1();
        n1.value = i;
        if (tail != null) {
            tail.next = n1;
            n1.prev = tail;
            tail = n1;
        } else if (head == null) {
            head = n1;
            tail = head;
        }
    }

    public int pop() {
        //int i = 0;
        if (tail == null) {
            System.out.println("Stack is empty");
            return (0);
        } else {
            int i = tail.value;
            if (tail.prev == null) {
                //Node1 temp = tail;
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            return i;
        }
    }

    public int peek() {
        if (tail != null) return tail.value;
        System.out.println("No stack");
        return 0;
    }


    public void display() {
        while (head != tail)
            System.out.println(head.value);

        //head = head.next;

    }

    public int size() {
        if (tail == null) return 0;
        int i = 0;
        Node1 n = head;
        while (n != null) {
            i++;
            n = n.next;
        }
        return i;
    }

    @Override
    public String toString() {
        Node1 n = head;
        String s = null;

        while (n != null) {
            s = s + n.value + " ";
            n = n.next;
        }
        return s.replaceAll("null", "");

    }

    public static void main(String[] args) {
        StackPapa sp = new StackPapa();

        sp.push(1);
        sp.push(2);
        sp.push(3);
        //sp.push(4);
        System.out.println(sp.pop() + " " + sp.pop() + " " + sp.pop());

        System.out.println(sp.peek());

        sp.push(3);
        sp.push(4);
        System.out.println(sp.size());
        System.out.println(sp.toString());

        //System.out.println(sp.size());
        // System.out.println(sp.toString());
        //sp.display();
        //System.out.println(sp.toString());
    }

}
