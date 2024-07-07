package com.javatest.leet_easy;

public class CheckifAllAsAppearsBeforeAllBs {
    public static boolean checkString(String s) {
        boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b')
                check = true;
            else if (check && s.charAt(i) == 'a')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkString("abab"));
    }
}
