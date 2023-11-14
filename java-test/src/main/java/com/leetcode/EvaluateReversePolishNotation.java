package com.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*" -> { // multiply
                    stack.push(stack.pop() * stack.pop());
                }
                case "+" -> { // sum
                    stack.push(stack.pop() + stack.pop());
                }
                case "-" -> { // minus
                    int[] values = {stack.pop(), stack.pop()};
                    stack.push(values[1] - values[0]);
                }
                case "/" -> { // divide
                    int[] values = {stack.pop(), stack.pop()};
                    stack.push(values[1] / values[0]);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.