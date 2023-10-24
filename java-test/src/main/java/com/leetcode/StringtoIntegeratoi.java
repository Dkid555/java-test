package com.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringtoIntegeratoi {
    public static int myAtoi(String str) {
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        boolean minus = false;
        boolean flag = true;
        Set<Integer> reference = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < str.length(); i++) {
            if (reference.contains(str.charAt(i) - '0')) {
                stack.push(str.charAt(i) - '0');
                if (stack.size() == 1 && i > 0 && str.charAt(i - 1) == '-') {
                    minus = true;
                }
                flag = false;
            } else if (flag && !reference.contains(str.charAt(i) - '0') && str.charAt(i) != '-' && str.charAt(i) != '+')
                return 0;
            else if (!flag)
                break;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            result += stack.pop() * Math.pow(10, i++);
            if (result > Integer.MAX_VALUE)
                result = Integer.MAX_VALUE;
        }//2147483648
        result = minus ? (result == Integer.MAX_VALUE ? (Integer.MIN_VALUE) : -result) : result;
        return (int) result;
    }


    public static int myAtoi2(String str) {
        str = str.strip();
        if (str.isEmpty())
            return 0;
        int sign = str.charAt(0) == '-' ? -1 : 1; // -/+
        str = (str.charAt(0) == '+' || str.charAt(0) == '-') ? str.substring(1) : str;
        long result = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i)))
                break;
            result = result * 10 + (str.charAt(i) - '0');
            if (sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return sign * (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2("42"));
    }
}
