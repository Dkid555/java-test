package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingtheSentence {
    public static String sortSentence(String s) {
        return Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(str -> str
                        .charAt(str.length() - 1) - '0')).map(str1 -> str1.substring(0, str1.length() - 1)).
                collect(Collectors.joining(" "));

    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
