package com.javatest.leetcode;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        return n.chars().max().getAsInt() - '0';
    }
}
