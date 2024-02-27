package com.leetcode;

//import com.data.Stack;

import java.util.Stack;

public class MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                stack.add('(');
                max = Math.max(stack.size(), max);
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return max;
    }
}
