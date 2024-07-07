package com.Amazon.Interval;

import java.lang.reflect.Array;
import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        Stack<int[]> stack = new Stack<>();

        Arrays.stream(intervals).sorted(Comparator.comparing(a -> a[0])).forEach(curr_interv -> {
            if(!stack.isEmpty()){
                int[] prev_interval = stack.pop();
                if(prev_interval[0] == curr_interv[0] || prev_interval[1] >= curr_interv[0]) {
                    stack.add(new int[]{prev_interval[0], Math.max(curr_interv[1], prev_interval[1])});
                } else if (curr_interv[1] <= prev_interval[1]) {
                    stack.add(new int[]{curr_interv[0], prev_interval[1]});
                }
                else {
                    stack.add(prev_interval);
                    stack.add(curr_interv);
                }
            }else
                stack.add(curr_interv);
        });

        return stack.toArray(int[][]::new);
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i < intervals.length; ++i){
            int[] curr_interv = intervals[i];
            if(!stack.isEmpty()){
                int[] prev_interval = stack.pop();
                if(prev_interval[0] == curr_interv[0] || prev_interval[1] >= curr_interv[0]) {
                    stack.add(new int[]{prev_interval[0], Math.max(curr_interv[1], prev_interval[1])});
                } else if (curr_interv[1] <= prev_interval[1]) {
                    stack.add(new int[]{curr_interv[0], prev_interval[1]});
                }
                else {
                    stack.add(prev_interval);
                    stack.add(curr_interv);
                }
            }else
                stack.add(curr_interv);
        }


        return stack.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 2}, {1, 3}, {-1, 0},{2, 4}, {4, 5}})));
    }

    //        for(int i = 1; i < intervals.length; ++i){
    //            int[] curr_interv = intervals[i];
    //            if(!stack.isEmpty()){
    //                int[] prev_interval = stack.pop();
    //                if(prev_interval[0] == curr_interv[0] || prev_interval[1] >= curr_interv[0]) {
    //                    stack.add(new int[]{prev_interval[0], Math.max(curr_interv[1], prev_interval[1])});
    //                } else if (curr_interv[1] <= prev_interval[1]) {
    //                    stack.add(new int[]{curr_interv[0], prev_interval[1]});
    //                }
    //                else {
    //                    stack.add(prev_interval);
    //                    stack.add(curr_interv);
    //                }
    //            }else
    //                stack.add(curr_interv);
    //        }
}
