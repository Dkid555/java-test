package com.leet_easy;

public class ValidPalindromeII {

    static boolean checkFin(String string, int i, int j) {
        while (i <= j) {
            if (string.charAt(i) == string.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    static boolean check(String string) {
        String str = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = string.length() - 1;

        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else return checkFin(str, i + 1, j) || checkFin(str, i, j - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("dedmeadeecccceedaedued"));

    }
}
//dedmeadeecccceedaeded