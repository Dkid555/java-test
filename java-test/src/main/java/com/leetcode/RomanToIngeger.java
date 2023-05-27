package com.leetcode;

import java.util.ArrayList;

public class RomanToIngeger {
    public static int romanToInt(String s) {
        int sum = 0;
        int value = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    value = 1;
                    break;
                case 'V':
                    value = 5;
                    break;
                case 'X':
                    value = 10;
                    break;
                case 'L':
                    value = 50;
                    break;
                case 'C':
                    value = 100;
                    break;
                case 'D':
                    value = 500;
                    break;
                case 'M':
                    value = 1000;
                    break;
            }
            if (value < prev) {
                sum -= value;
            } else {
                sum += value;
            }
            prev = value;
        }
        return sum;


    }

//OR

    protected static int romantoint(String s) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (char lst : s.toCharArray()) {
            if (lst == 'I') {
                list.add(1);
            }

            if (lst == 'V') {
                list.add(5);
            }
            //return 5
            if (lst == 'X') {
                list.add(10);
            }
            if (lst == 'L') {
                list.add(50);
            }
            if (lst == 'C') {
                list.add(100);
            }
            if (lst == 'D') {
                list.add(500);
            }
            if (lst == 'M') {
                list.add(1000);
            }
        }

        if (list.size() == 1) {
            return list.get(0);
        } else {
            int sm = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1 && list.get(i) < list.get(i + 1)) {
                    sm = sm - list.get(i);
                } else {
                    sm = sm + list.get(i);
                }
            }
            return sm;

        }

    }

    public static void main(String[] args) {
        String s = new String("XXXV");
        System.out.println(romantoint(s));
        System.out.println(romanToInt(s));

    }
}



/*
class Solution {

}*/