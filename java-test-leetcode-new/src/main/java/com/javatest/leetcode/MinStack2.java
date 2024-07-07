package com.javatest.leetcode;

public class MinStack2 {
    private class StackNodes {
        int value;
        int min;
        StackNodes next;

        public StackNodes() {
        }

        ;

        public StackNodes(int value, StackNodes next, int min) {
            this.value = value;
            this.next = next;
            this.min = min;
        }

    }

    StackNodes node;

    public MinStack2() {
//        this.node = new StackNodes();
    }

    public void push(int val) {
        if (this.node == null) {
            this.node = new StackNodes(val, null, val);
        } else {
            this.node = new StackNodes(val, this.node, Math.min(val, this.node.min));
        }
    }

    public void pop() {
        this.node = this.node.next;
    }

    public int top() {
        return this.node.value;
    }

    public int getMin() {
        return this.node.min;
    }
}
