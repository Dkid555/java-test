package com.javatest.leet_easy;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.length() == 0) return true;
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if(s.equals(goal)) return true;
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        }
        return false;
    }
    public static boolean rotateString2(String s, String goal) {
        return (s+s).contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString2("abcde","cdeab"));
    }
}
