package com.leetcode;

public class ReverseString {

    public static String reverse(String myString) {
        String str = null;
        char[] s = new char[myString.length()];
        s = myString.toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            str = str + s[i];
        }

        return str.replaceAll("null", "");
    }

    public static void main(String[] args) {
        String test = "Reverse Me";
        System.out.println(reverse(test));
    }
}
