package com.javatest.leetcode;

import java.util.Arrays;

public class BoatstoSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right--] <= limit)
                ++left;
            ++boats;
        }
        return boats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }
}
