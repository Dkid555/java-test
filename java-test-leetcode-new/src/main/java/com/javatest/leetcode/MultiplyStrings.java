package com.javatest.leetcode;

import java.util.Arrays;
import java.util.List;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiply2(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int left = i + j;
                int right = i + j + 1;
                int sum = res[right] + multiply;

                res[left] += sum / 10;
                res[right] = sum % 10;
            }
        StringBuilder sb = new StringBuilder();
//        Arrays.asList(res).forEach((val) -> { sb.append(val);});
        for (int val : res) if (!(sb.length() == 0 && val == 0)) sb.append(val);
        return sb.length() != 0 ? sb.toString() : "0";
//        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(multiply2("0", "0"));
//        System.out.println(multiply2("123", "456"));
    }
}

class mult {
    private static String multiply(String num1, String num2) {
        int nu1 = Integer.parseInt(num1);
        int nu2 = Integer.parseInt(num2);
        long total = nu1 * nu2;
        return String.valueOf(total);
    }


    public static void main(String[] args) {
//        System.out.println(multiply("123", "456"));

        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4, -5, 6, -7, 8, -9, 10, 0);

        numbers.stream().filter(n -> n >= 0).forEach(n -> {
            if (n > 0) System.out.println(n + " is Positive");
            else System.out.println(n + " is Zero");
        });
        System.out.println("============================================================================================");
        numbers.forEach(n -> {
            if (n > 0) System.out.println(n + " is Positive");
            else if (n == 0) System.out.println(n + " is Zero");
            else System.out.println(n + " is Negative");
        });

        System.out.println("============================================================================================");

        numbers.stream().filter(n -> n <= 0).forEach(n -> {
            if (n == 0) System.out.println(n + " is Zero");
            else System.out.println(n + " is negative");
        });
    }
}





