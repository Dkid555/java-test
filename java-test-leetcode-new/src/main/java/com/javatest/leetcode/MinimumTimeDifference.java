package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        List<Integer> timeToInt = new ArrayList<>();
        for (String timeStanp : timePoints) {
            timeToInt.add(Integer.parseInt(timeStanp.substring(0, 2)) * 60 + Integer.parseInt(timeStanp.substring(3)));
        }
        Collections.sort(timeToInt);
        for (int i = 1; i < timeToInt.size(); ++i) {
            result = Math.min(result, timeToInt.get(i) - timeToInt.get(i - 1));
        }
        result = Math.min(result, timeToInt.get(0) + 24 * 60 - timeToInt.get(timeToInt.size() - 1));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMinDifference(List.of("00:00", "23:59", "00:00")));
    }
}

//Given a list of 24-hour clock time points in "HH:MM" format,
// return the minimum minutes difference between any two time-points in the list.
//
//
//Example 1:
//
//Input: timePoints = ["23:59","00:00"]
//Output: 1
//Example 2:
//
//Input: timePoints = ["00:00","23:59","00:00"]
//Output: 0
