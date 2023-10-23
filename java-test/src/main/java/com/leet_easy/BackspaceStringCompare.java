package com.leet_easy;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        return Backspace(new StringBuilder(s)).toString().contentEquals(Backspace(new StringBuilder(t)));
    }

    private static StringBuilder Backspace(StringBuilder str) {
        int lenght = str.length();
        for (int i = 0; i < lenght; i++) {
            if (str.charAt(i) == '#') {
                str.deleteCharAt(i);
                if (i != 0) {
                    str.deleteCharAt(--i);
                }
                --i;
                lenght = str.length();
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }
}

//Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
//
//Note that after backspacing an empty text, the text will continue empty.