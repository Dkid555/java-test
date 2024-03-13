package com.meta.other;

import java.util.Set;
import java.util.Stack;

public class BasicCalculatorII {

    private static void checkSignalandAdd(char signal, Stack<Integer> stack, StringBuilder number) {
        if (signal == '+')
            stack.add(Integer.parseInt(number.toString()));
        else if (signal == '-') {
            stack.add(Integer.parseInt('-' + number.toString()));
        } else if (signal == '*') {
            stack.add(stack.pop() * Integer.parseInt(number.toString()));
        } else if (signal == '/') {
            stack.add(stack.pop() / Integer.parseInt(number.toString()));
        }
    }

    public static int calculate(String to_compute) {
        int result = 0;
        StringBuilder number = new StringBuilder();

        Set<Character> PlusMinusPlusMinusDevide = Set.of('+', '-', '*', '/');
        Stack<Integer> stack = new Stack<>();
        char signal = '+';

        for (char ch : to_compute.toCharArray()) {
            if (ch == ' ')
                continue;
            if (PlusMinusPlusMinusDevide.contains(ch)) {
                checkSignalandAdd(signal, stack, number);
                signal = ch;
                number = new StringBuilder();
            } else
                number.append(ch);
        }

        if (!number.isEmpty()) {
            checkSignalandAdd(signal, stack, number);
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
