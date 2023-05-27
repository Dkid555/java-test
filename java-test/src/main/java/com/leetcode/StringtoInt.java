package com.leetcode;

import java.util.Stack;

import static java.lang.Character.getNumericValue;

//import static jdk.internal.org.jline.utils.Colors.s;

public class StringtoInt {
    public static int myAtoi(String s) {
        if (s.equals("")) {
            return 0;
        }

        // helper variables
        int res = 0, i = 0, sign = 1;

        // get rid of whitespace
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // check for sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            // change if negative, iterate
            if (s.charAt(i++) == '-') {
                sign = -1;
            }
        }

        // now iterate across digits if any
        // should only be in range 0-9
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // check if we will go over the max
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }

            // update res
            res = res * 10 + (s.charAt(i++) - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String s = "4193 428";
        int sum = 0;
        int k = 1;
        //int z = Integer.parseInt(s);
        Stack<Character> num = new Stack<>();
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2'
                    || s.charAt(i) == '3'
                    || s.charAt(i) == '4'
                    || s.charAt(i) == '5'
                    || s.charAt(i) == '6'
                    || s.charAt(i) == '7'
                    || s.charAt(i) == '8'
                    || s.charAt(i) == '9') {
                while (!num.isEmpty() && num.peek() == '-') num.pop();
                num.push(s.charAt(i));
            } else if (s.charAt(i) == '-') {
                num.push(s.charAt(i));
            }
        }
        if (num.isEmpty()) {
            return;
        }
        int i = 0;
        while (!num.isEmpty()) {
            if (num.peek() == '-') {
                k = -1;
                num.pop();
            }

            if (num.peek() == '1' || num.peek() == '2'
                    || num.peek() == '3'
                    || num.peek() == '4'
                    || num.peek() == '5'
                    || num.peek() == '6'
                    || num.peek() == '7'
                    || num.peek() == '8'
                    || num.peek() == '9') {
                sum = sum + (int) Math.pow(10, num.size() - 1) * getNumericValue(num.pop());
                //i++;
            }
        }
        //System.out.println(z);
        //int a = Integer.parseInt(s);
        System.out.println(myAtoi(s));
        System.out.println(sum * k);
    }
}

