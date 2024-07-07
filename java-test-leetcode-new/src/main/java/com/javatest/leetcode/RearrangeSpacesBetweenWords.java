package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public static String reorderSpaces(String text) {
        int count_spaces = 0;
        List<String> stringList = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        boolean check = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                ++count_spaces;
                if (check) {
                    check = false;
                    stringList.add(str.toString());
                    str = new StringBuilder();
                }
            } else {
                check = true;
                str.append(text.charAt(i));
            }
        }
        if (!str.isEmpty())
            stringList.add(str.toString());
        if (stringList.size() > 1) {
            String dashes = " ".repeat(count_spaces / (stringList.size() - 1));
            return String.join(dashes, stringList) + " ".repeat(count_spaces % (stringList.size() - 1));
        } else {
            return String.join("", stringList) + " ".repeat(count_spaces);
        }
    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("a"));
    }
}

