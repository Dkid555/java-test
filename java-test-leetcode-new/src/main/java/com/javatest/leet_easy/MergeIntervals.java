package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < intervals.length && end >= intervals[i + 1][0])
                end = Math.max(intervals[++i][1], end);
            list.add(new int[]{start, end});
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.