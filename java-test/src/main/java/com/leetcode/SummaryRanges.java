package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/*
* You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
* That is, each element of nums is covered by exactly one of the ranges,
* and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b*/

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int previous = nums[0];
        Deque<Integer> temp = new ArrayDeque<>();
        temp.addLast(previous);
        for (int i = 1; i < nums.length; i++) {
            if (previous != nums[i] - 1) {
                generateResult(result, temp);
                temp.clear();
            }
            previous = nums[i];
            temp.addLast(previous);
        }
        if (!temp.isEmpty()) {
            generateResult(result, temp);
        }
        return result;
    }

    private static void generateResult(List<String> result, Deque<Integer> temp) {
        if (temp.size() > 1) {
            String first = temp.peekFirst().toString();
            String end = temp.peekLast().toString();
            String help = first + "->" + end;
            result.add(help);
        } else {
            String help = temp.pop().toString();
            result.add(help);
        }
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{}));
    }
}
