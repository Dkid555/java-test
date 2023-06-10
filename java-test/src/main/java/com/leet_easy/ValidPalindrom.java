package com.leet_easy;

public class ValidPalindrom {
    static boolean check(String string) {
        String st = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder str = new StringBuilder(st);
        String s = str.reverse().toString();
        return st.equals(s);
    }

    static boolean check2(String string) {
        String st = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < st.length() / 2; i++) {
            if (st.charAt(i) != st.charAt(st.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(check2("race a car"));
    }
}
