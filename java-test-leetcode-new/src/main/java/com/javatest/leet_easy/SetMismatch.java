package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] = map.contains(nums[i]) ? nums[i] : result[0];
            map.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            result[1] = !map.contains(i + 1) ? i + 1 : result[1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1, 3, 4})));
    }
}

//You have a set of integers s, which originally contains all the numbers from 1 to n.
// Unfortunately, due to some error, one of the numbers in s got duplicated to another
// number in the set, which results in repetition of one number and loss of another number.
//
//You are given an integer array nums representing the data status of this set after the error.
//
//Find the number that occurs twice and the number that is missing and return them in the form of an array.