package com.javatest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberofDifferentIntegersinaString {
    public int numDifferentIntegers(String word) {
        String[] arr = word.replaceAll("[a-zA-Z]", " ").split("\\s+");
        Set<String> set = new HashSet<String>();

        for (String str : arr) {
            if (!str.isEmpty())
                set.add(str.replaceAll("^0*", ""));
        }

        return set.size();
    }
}
