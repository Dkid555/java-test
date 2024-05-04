package com.Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    //You are given an array of
    // intervals, where intervals[i] = [starti, endi] and each starti is unique.
    //
    //The right interval for an interval i is an interval j
    // such that startj >= endi and startj is minimized. Note that i may equal j.
    //
    //Return an array of right interval indices for each interval i.
    // If no right interval exists for interval i, then put -1 at index i.
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<intervals.length; i++) {
            int[] interval = intervals[i];
            max = Math.max(max, interval[0]);
            map.put(interval[0], i);
        }

        for(int i=0; i<intervals.length; i++){
            int end = intervals[i][1];
            if(end > max) {
                res[i] = -1;
                continue;
            }
            int j = end;
            while(!map.containsKey(j)) {
                j++;
            }
            res[i] = map.get(j);
        }

        return res;
    }
}
