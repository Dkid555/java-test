package com.leet_easy;

public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        String result = "";
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0)
                result += c;
            if (c == ')' && opened-- > 1)
                result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
//A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
//
//For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
//
//Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
//
//Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.