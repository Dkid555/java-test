package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildanArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        int index = 0, current = 1;
        do {
            stack.push(current);
            res.add("Push");
            ++current;

            if (stack.peek() == target[index]) {
                index++;
            } else {
                stack.pop();
                res.add("Pop");
            }
        } while (index != target.length);
        return res;
    }
}
