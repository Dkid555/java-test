package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        List<String> stringOfNums = new java.util.ArrayList<>(Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).toList());
//        stringOfNums.sort((a, b) -> (b + a).compareTo(a + b));
        String result = String.join("", stringOfNums);
        return result.startsWith("0") ? "0" : result;
    }

    public String largestNumber2(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        for (String str : s) {
            sb.append(str);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;

    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
