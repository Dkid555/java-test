package com.leet_easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AddStrings {
    static String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) return addStrings(num2, num1);
        Stack<Integer> help = new Stack<>();
        String str = "";
        int i = num1.length() - 1;
        int k = num2.length() - 1;
        while (i != -1 || k != -1) {
            if (i != -1 && k != -1) {
                int j = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(k));
                if (!help.isEmpty()) j += help.pop();
                if (j / 10 > 0) {
                    j = j % 10;
                    help.push(1);
                }
                str = j + str;
                --i;
                --k;
            } else if (i != -1) {
                int j = Character.getNumericValue(num1.charAt(i));
                if (!help.isEmpty()) j += help.pop();
                if (j / 10 > 0) {
                    j = j % 10;
                    help.push(1);
                }
                str = j + str;
                --i;
            }
        }
        if (!help.isEmpty()) {
            str = "1" + str;
        }
        return str;
    }


    static String addStrings2(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int c = 0, m = 0;
        while (n1 >= 0 || n2 >= 0 || m > 0) {
            c = 0;
            c = ((n1 >= 0) ? num1.charAt(n1--) - '0' : 0) + ((n2 >= 0) ? num2.charAt(n2--) - '0' : 0) + m;
            m = c / 10;
            ans.append((char) (c % 10 + '0'));
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {

        System.out.println(addStrings("456", "77"));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list = list.stream().map(x -> x * x - 2).collect(Collectors.toList());
        System.out.println(list);

    }
}
