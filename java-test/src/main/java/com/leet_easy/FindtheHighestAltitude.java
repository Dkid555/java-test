package com.leet_easy;


//There is a biker going on a road trip. The road trip consists
// of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
//
//You are given an integer array gain of length n where gain[i] is the
// net gain in altitude between points i and i + 1 for all (0 <= i < n).
// Return the highest altitude of a point.
public class FindtheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int maxsum = 0;
        int sum = 0;
        for (int diff : gain
        ) {
            sum += diff;
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }


    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}
