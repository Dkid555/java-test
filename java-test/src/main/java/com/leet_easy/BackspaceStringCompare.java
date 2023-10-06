package com.leet_easy;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(t);
        str1 = Backspace(str1);
        str2 = Backspace(str2);
        return str1.toString().contentEquals(Backspace(str2));
    }

    private static StringBuilder Backspace(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (i > 0) {
                    str.deleteCharAt(i);
                    str.deleteCharAt(i - 1);
                    i--;
                } else {
                    str.deleteCharAt(i);
                    i--;
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }
}
