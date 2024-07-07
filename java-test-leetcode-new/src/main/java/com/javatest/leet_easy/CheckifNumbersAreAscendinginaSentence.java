package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.List;

public class CheckifNumbersAreAscendinginaSentence {
    public static boolean areNumbersAscending(String s) {
        List<Integer> list = Arrays.stream(
                s.replaceAll("([a-z])", " ").replaceAll("( )+", " ").trim().
                        split(" ")).map(Integer::parseInt).toList();
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }
        return true;
    }

    public boolean areNumbersAscendings(String s) {
        int previous = 0;
        boolean check = false;
        int current = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                check = true;
                current = current * 10 + (c - '0');
            } else if (check) {
                if (previous >= current) {
                    return false;
                }
                check = false;
                previous = current;
                current = 0;
            }
        }
        if (check)
            return current > previous;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("hello world 5 x 5"));
    }
}
