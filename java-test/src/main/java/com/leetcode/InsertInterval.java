package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InsertInterval {
    public static int[][] insert(int[][] ints, int[] newInterval) {
        int[][] intervals = new int[ints.length + 1][2];
        for (int i = 0; i < ints.length; i++) {
            intervals[i][0] = ints[i][0];
            intervals[i][1] = ints[i][1];
        }
        intervals[intervals.length - 1][0] = newInterval[0];
        intervals[intervals.length - 1][1] = newInterval[1];

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int count = 0, start = intervals[0][0], end = intervals[0][1];
        int[][] resTemp = new int[intervals.length][2];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s <= end) {
                end = Math.max(e, end);
            } else {
                resTemp[count][0] = start;
                resTemp[count++][1] = end;
                start = s;
                end = e;
            }
        }
        resTemp[count][0] = start;
        resTemp[count++][1] = end;

        int[][] res = new int[count][2];
        for (int i = 0; i < count; i++) {
            res[i] = resTemp[i];
        }
        return res;
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, size = intervals.length;
        while (i < size && intervals[i][1] < newInterval[0]) ans.add(intervals[i++]);
        while (i < size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        ans.add(newInterval);
        while (i < size) ans.add(intervals[i++]);
//        int[][] res = new int[ans.size()][2];
//        for (int index = 0; index < res.length; index++){
//            res[index] = ans.get(index);
//        }
        //        int[][]res = ans.stream().toArray(int[][] :: new);
        return ans.toArray(int[][]::new);
    }


    public static void main(String[] args) {
        int[][] result = insert2(new int[][]{new int[]{1, 2}, new int[]{3, 5},
                new int[]{8, 10}, new int[]{12, 16}}, new int[]{4, 8});
        System.out.println();


        List<Integer> numbers = Arrays.asList(-2, 4, 5, 67, -15, -1);
        List<Integer> res = numbers.stream().map(x -> x * x).sorted().toList();


        int max = numbers.stream().max(Integer::compareTo).get();


        System.out.println("from: " + numbers);
        System.out.println("to: " + res);

        System.out.println("max from numbers: " + max);
        System.out.println("min from numbers: " +
                numbers.stream().min(Integer::compareTo).get());
        System.out.println("max from res " +
                res.stream().max(Integer::compareTo).get());
        System.out.println("min from res " +
                res.stream().min(Integer::compareTo).get());
        Set<Integer> set = numbers.stream().map(x -> x - 10).collect(Collectors.toSet());
        System.out.println("set: " + set);

        List<Integer> num = Arrays.asList(2, 3, 4, 5, 6);
        int even = num.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);

        System.out.println("from: " + num + " even is: " + even);
    }
}
