package com.data;

import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int i) {
        arr.add(i);
    }

    public int pop() {
        return arr.remove(0);
    }

    public int push(int i) {
        this.add(i);
        return i;
    }

    public String toString() {
        return arr.toString();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 0; i < 10; i++) q.add(i);
        q.pop();
        System.out.println(q.toString());

    }
}
