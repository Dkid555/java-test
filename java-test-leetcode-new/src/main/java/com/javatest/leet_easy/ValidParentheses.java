package com.javatest.leet_easy;

import java.util.Stack;

public class ValidParentheses {
    static boolean check(String pars) {
        Stack<Character> sum = new Stack<>();
        for (int i = 0; i < pars.length(); i++) {
            if (pars.charAt(i) == '(' || pars.charAt(i) == '{' || pars.charAt(i) == '[') sum.push(pars.charAt(i));
            else if (sum.isEmpty()) return false;
            else {
                if (pars.charAt(i) == ')' && sum.peek() == '(') sum.pop();
                else if (pars.charAt(i) == '}' && sum.peek() == '{') sum.pop();
                else if (pars.charAt(i) == ']' && sum.peek() == '[') sum.pop();
                else return false;
            }
        }
        if (sum.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        String pars = "{}";
        System.out.println(check(pars));
    }
}
