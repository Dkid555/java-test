package com.javatest.leetcode;

public class IsPalindromeString {
    public static String reverse(String myString) {
        String str = null;
        char[] s = new char[myString.length()];
        s = myString.toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            str = str + s[i];
        }

        return str.replaceAll("null", "");
    }

    public static boolean isPalindrom(String x) {
        String k = x.toUpperCase().replaceAll(" ", "").replaceAll(";", "").replaceAll(":", "").replaceAll(",", "");
        String z = reverse(k);
        return k.equals(z);
    }

    public static void main(String[] args) {
        String x = "Lol MAM LOL";
        System.out.println(isPalindrom(x));


    }

}
