package com.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Let's say a positive integer is a super-palindrome if it is a palindrome,
// and it is also the square of a palindrome.
//
//Given two positive integers left and right represented as strings,
// return the number of super-palindromes integers in the inclusive range [left, right].
public class SuperPalindromes {
    public static int superpalindromesInRange(String left, String right) {
        var count = 0;
        Set<Double> set = new HashSet<>();
        var begin = Integer.parseInt(left);
        for (int i = 0; i <= Integer.parseInt(right); i++) {
            if (i < begin) {
                isPalindrom(String.valueOf(i), set);
            } else {
                if (isPalindrom(String.valueOf(i), set))
                    if (set.contains(Math.sqrt(i)))
                        count++;
            }
        }
        return count;
    }

    public static String reverse(String myString) {
        String str = "";
        char[] s = new char[myString.length()];
        s = myString.toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            str = str + s[i];
        }

        return str;
    }

    public static boolean isPalindrom(String x, Set<Double> set) {
        String k = x.toUpperCase().replaceAll(" ", "").replaceAll(";", "").replaceAll(":", "").replaceAll(",", "");
        String z = reverse(k);
        if (k.equals(z)) {
            set.add((double) Integer.parseInt(k));
            return true;
        }
        return false;
    }

    public static int superpalindromesInRange2(String left, String right) {
        // left <= 9 and right >= 9 -> ans = 1 else ans = 0

        int ans = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;

        for (int dig = 1; dig < 10; dig++) {
            boolean isOdd = dig % 2 > 0 && dig != 1;
            int innerLen = (dig >> 1) - 1,
                    innerLim = Math.max(1, (int) Math.pow(2, innerLen)),
                    midPos = dig >> 1, midLim = isOdd ? 3 : 1;
            for (int edge = 1; edge < 3; edge++) {
                char[] pal = new char[dig];
                Arrays.fill(pal, '0');
                pal[0] = (char) (edge + 48);
                pal[dig - 1] = (char) (edge + 48);
                if (edge == 2) {
                    innerLim = 1;
                    midLim = Math.min(midLim, 2);
                }
                for (int inner = 0; inner < innerLim; inner++) {
                    if (inner > 0) {
                        String innerStr = Integer.toString(inner, 2);
                        while (innerStr.length() < innerLen)
                            innerStr = "0" + innerStr;
                        for (int i = 0; i < innerLen; i++) {
                            pal[1 + i] = innerStr.charAt(i);
                            pal[dig - 2 - i] = innerStr.charAt(i);
                        }
                    }
                    for (int mid = 0; mid < midLim; mid++) {
                        if (isOdd) pal[midPos] = (char) (mid + 48);
                        String palin = new String(pal);
                        long square = Long.parseLong(palin) * Long.parseLong(palin);
                        if (square > Long.parseLong(right)) return ans;
                        if (square >= Long.parseLong(left) && isPal(Long.toString(square))) ans++;
                    }
                }
            }
        }
        return ans;
    }


    public static int superpalindromesInRange4(String left, String right) {
        int ans = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;
        for (int i = 1; i < 19684; i++) {
            String num = Integer.toString(i, 3);
            if (isPal(num)) {
                long square = Long.parseLong(num) * Long.parseLong(num);
                if (square > Long.parseLong(right)) return ans;
                if (square >= Long.parseLong(left) && isPal(Long.toString(square))) ans++;
            }
        }
        return ans;
    }

    private static boolean isPal(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(superpalindromesInRange4("40", "1000"));
    }
}
