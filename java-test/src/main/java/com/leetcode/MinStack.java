package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack {
    List<Integer> node;

    public MinStack() {
        this.node = new ArrayList<>();
    }

    public void push(int val) {
        this.node.add(val);
    }

    public void pop() {
        this.node.remove(this.node.size() - 1);
    }

    public int top() {
        return this.node.get(this.node.size() - 1);
    }

    public int getMin() {
        return Collections.min(this.node);
    }
}

