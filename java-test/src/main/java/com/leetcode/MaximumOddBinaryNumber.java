package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.joining()) + "1";
    }
}
