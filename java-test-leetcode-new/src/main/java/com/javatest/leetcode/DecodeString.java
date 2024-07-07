package com.javatest.leetcode;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder str = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i); //9
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStack.push(num);
            } else if (ch == '[') {
                strStack.push(str.toString());
                str = new StringBuilder();
            } else if (ch == ']') {
                int k = numStack.pop(); //eg. 3 //eg. 2
                StringBuilder tmp = new StringBuilder(strStack.pop()); //eg. a //eg. bc
                for (int j = 0; j < k; j++) {
                    tmp.append(str);  //aaa   //bcbc
                }
                str = tmp; //aaa  //aaabcbc

            } else {
                str.append(ch); //eg. a, b, c
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
