package com.javatest.leetcode;


import java.util.Iterator;
import java.util.Stack;

public class ImplementQueueusingStacks {
    private static class MyQueue {

        Stack<Integer> stack;

        public MyQueue() {
            this.stack = new Stack<>();
        }

        public void push(int x) {
            this.stack.push(x);
        }

        public int pop() {
            Iterator<Integer> iterable = this.stack.iterator();
            int fin = -1;
            if (iterable.hasNext()) {
                fin = iterable.next();
            }
            this.stack = new Stack<>();
            while (iterable.hasNext()) {
                this.stack.push(iterable.next());
            }
            return fin;
        }

        public int peek() {
            Iterator<Integer> iterable = this.stack.iterator();
            int fin = -1;
            if (iterable.hasNext()) {
                fin = iterable.next();
            }
            return fin;
        }

        public boolean empty() {
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
