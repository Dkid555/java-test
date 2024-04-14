package com.Amazon.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while (i < size && intervals[i][1] < newInterval[0]){ // начало нового интервала больше чем конец прошлого
            result.add(intervals[i++]);
        }
        while (i < size && intervals[i][0] <= newInterval[1]){ // конец нового интервала меньше начала прошлого
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        result.add(newInterval);
        while (i< size)
            result.add(intervals[i++]);

        return result.toArray(int[][] :: new);

    }
}
//You are given an array of non-overlapping intervals intervals where
// intervals[i] = [starti, endi] represent the start and the end of the
// ith interval and intervals is sorted in ascending order by starti.
// You are also given an interval newInterval = [start, end]
// that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in
// ascending order by starti and intervals still does not have any overlapping
// intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.