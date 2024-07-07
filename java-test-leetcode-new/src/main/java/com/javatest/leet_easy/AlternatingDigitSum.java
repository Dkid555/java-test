package com.javatest.leet_easy;

public class AlternatingDigitSum {
    public static int alternateDigitSum(int n) {
        int sum = 0;
        int i = 1;
        for (char num : String.valueOf(n).toCharArray()) {
            if (i % 2 == 1)
                sum += num - '0';
            else
                sum -= num - '0';
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(alternateDigitSum(111));
    }
}
