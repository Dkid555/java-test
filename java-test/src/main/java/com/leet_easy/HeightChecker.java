package com.leet_easy;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int count = 0;
        int[] sort = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sort);
        for (int i = 0; i < heights.length; i++) {
            count += sort[i] != heights[i] ? 1 : 0;
        }
        return count;
    }

    // faster, sort by index(small values)
    public static int heightChecker2(int[] heights) {
        int[] heightFreq = new int[101];
        for (int height : heights) {
            heightFreq[height]++;
        }
        int count = 0;
        int currentHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightFreq[currentHeight] == 0) {
                currentHeight++;
            }
            count += currentHeight != heights[i] ? 1 : 0;
            heightFreq[currentHeight]--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker2(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
//A school is trying to take an annual photo of all the students.
// The students are asked to stand in a single file line in non-decreasing order by height.
// Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
//
//You are given an integer array heights representing the current order that the students are standing in.
// Each heights[i] is the height of the ith student in line (0-indexed).
//
//Return the number of indices where heights[i] != expected[i].
