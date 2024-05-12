package com.Amazon;

import java.util.Stack;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'a', 'b','b','c','c','c'}));
    }
    public static int compress(char[] chars) {
        StringBuilder s =  new StringBuilder("" + chars[0]);
        char prev = chars[0];
        for (int i = 1; i < chars.length; ++i){
            char current_char = chars[i];
            if(current_char == prev){
                int count = 1;
                while (i < chars.length && chars[i] == prev){
                    ++i;
                    ++count;
                }
                --i;
                s.append(count);
            }
            else {
                s.append(current_char);
                prev = current_char;
            }
        }
        return s.length();
    }
}
