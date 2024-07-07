package com.javatest.data;


import java.util.ArrayList;

/*
 * Stack are based on LIFO(last in first out)
 * */
public class Stack {

    ArrayList<Integer> arr = new ArrayList<>();

    public int push(Integer i) {
        this.add(i);
        return i;
    }

    public void add(Integer i) {
        arr.add(i);
    }


    public Integer pop() {
        Integer i = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        return i;
    }

    public int size() {
        return arr.size();
    }

    public int peek() {
        return arr.get(arr.size() - 1);
    }

    @Override
    public String toString() {
        return arr.toString();
    }


    public static void main(String[] args) {

        Stack stack = new Stack();
        int a = stack.push(1);
        stack.add(10);
        for (int i = 0; i < 10; i++) stack.add(i);

        System.out.println(a + " " + stack.toString());

    }
}


