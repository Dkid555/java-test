package Amazon.AnotherPrep.Strings;

import java.util.*;

public class MinimumRemovetoMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }
    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stackOpenBracet = new Stack<>();
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < chars.length; ++i){
            char ch = chars[i];
            if(ch == ')'){
                if(!stackOpenBracet.isEmpty()){
                    stackOpenBracet.pop();
                }else {
                    toRemove.add(i);
                }
            } else if (ch == '(') {
                stackOpenBracet.push(i);
            }
        }
        while (!stackOpenBracet.isEmpty()){
            chars[stackOpenBracet.pop()] = '#';
        }
        for (int i : toRemove){
            chars[i] = '#';
        }
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            if(ch != '#')
                result.append(ch);
        }
        return result.toString();
    }
}
/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * */