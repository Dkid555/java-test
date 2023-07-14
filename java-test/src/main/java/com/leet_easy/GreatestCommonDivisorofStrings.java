package com.leet_easy;


//For two strings s and t, we say "t divides s"
// if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
//
//Given two strings str1 and str2,
// return the largest string x such that x divides both str1 and str2.
public class GreatestCommonDivisorofStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);
        if (!(str1 + str2).equals(str2 + str1)) return "";
        if (str1.length() % str2.length() == 0) {
            String sub = "";
            for (int i = 0; i < str1.length() / str2.length(); i++) {
                sub += str2;
            }
            if (sub.equals(str1)) return str2;
        }
        int mid = str2.length() / 2;
        String max = "";
        while (mid != 0) {
            String subS2 = str2.substring(0, mid);
            if (str1.length() % subS2.length() == 0) {
                String temp = "";
                boolean check = false;
                for (int i = 0; i < str1.length() / subS2.length(); i++) {
                    temp += subS2;
                    if (temp.equals(str2)) check = true;
                }
                if (temp.equals(str1) && check) return subS2;
            }
            mid--;
        }
        return "";
    }

    public static String gcdOfStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int length = gcd(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    private static int gcd(int str1_length, int str2_length) {
        // значит у них есть по любому общий делитель
        if (str2_length == 0)
            return str1_length;
        else {
            return gcd(str2_length, str1_length % str2_length);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings2("av", "avav"));
    }
}
