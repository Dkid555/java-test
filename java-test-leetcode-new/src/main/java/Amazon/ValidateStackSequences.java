package com.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }

    //Given two integer arrays pushed and popped each with distinct values,
    // return true if this could have been the result of a sequence of push
    // and pop operations on an initially empty stack, or false otherwise.
    //
    //
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        int popped_start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[popped_start]) {
                stack.pop();
                popped_start++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> popped_list = new ArrayList<>(Arrays.stream(popped).boxed().toList());
        for (int i = 0; i < pushed.length; ++i) {
            while (i < pushed.length && pushed[i] != popped_list.get(0)) {
                stack.add(pushed[i]);
                ++i;
            }
            if (i < pushed.length && popped_list.get(0) == pushed[i]) {
                popped_list.remove(0);
            }
            while (!popped_list.isEmpty() && !stack.isEmpty() && stack.peek() == popped_list.get(0)) {
                popped_list.remove(0);
                stack.pop();
            }
        }
        if (popped_list.size() != stack.size())
            return false;
        int popped_start = 0;
        while (!stack.isEmpty())
            if (stack.pop() != popped_list.get(popped_start++))
                return false;

        return true;
    }
}
//Given two integer arrays pushed and popped each with distinct values, return true
// if this could have been the result of a sequence
// of push and pop operations on an initially empty stack, or false otherwise.