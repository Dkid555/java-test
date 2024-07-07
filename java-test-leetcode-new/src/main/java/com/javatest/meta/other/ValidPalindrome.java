package com.javatest.meta.other;

public class ValidPalindrome {
    public static boolean isPalindrome(String string) {

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                stringBuilder.append(String.valueOf(ch).toLowerCase());
            }
        }
        int str_len = stringBuilder.length();
        if (str_len == 0) return true;
        for (int i = 0; i <= str_len / 2; ++i) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(str_len - i - 1))
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
