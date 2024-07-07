package com.Amazon;

public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("fre"));
    }
    public static String shortestPalindrome(String s) {
        if(s.isEmpty())
            return "";
        int end = s.length();
        for (; end >= 0; --end){
            if (isPalindrome(s.substring(0, end)))
                break;
        }
        if (end == s.length())
            return s;
        return new StringBuilder(s.substring(end)).reverse() + s;
    }
    private static boolean isPalindrome(String str){
        for(int i = 0; i < str.length() / 2; ++i){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}
