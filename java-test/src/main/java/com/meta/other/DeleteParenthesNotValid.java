package com.meta.other;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DeleteParenthesNotValid {
    public static String deleteParenthles(String string) {
        // нужно удалить не закрывающиеся скобочки '(' ')' из строки

        Stack<Integer> stack = new Stack<>();
        Set<Integer> toDeleteClosing = new HashSet<>();
        for (int i = 0; i < string.length(); ++i) {
            char ch = string.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.empty()) {
                    toDeleteClosing.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        Set<Integer> toDeleteOpening = new HashSet<>(stack);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            if (!toDeleteOpening.contains(i) && !toDeleteClosing.contains(i)) {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(deleteParenthles(")afaf(asfas))asfas()ASfa))("));
    }


    public static class NumberofCommonFactors {


    }
}
