package com.Amazon.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> reverse = Map.of( '}', '{', ']', '[', ')', '(' );
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i){
            char bracet = s.charAt(i);
            if(reverse.containsKey(bracet)){
               if(!stack.isEmpty() && stack.pop() == reverse.get(bracet))
                   continue;
               else
                   return false;
            }
            else{
                stack.push(bracet);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()()"));
    }
}


//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.