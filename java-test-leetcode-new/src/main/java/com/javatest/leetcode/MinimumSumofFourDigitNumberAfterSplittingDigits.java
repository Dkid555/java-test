package com.javatest.leetcode;

import java.util.Arrays;

public class MinimumSumofFourDigitNumberAfterSplittingDigits {
    public static int minimumSum(int num) {
//        StringBuilder numStr = new StringBuilder(String.valueOf(num));
//        int sum = Integer.MAX_VALUE;
//        for (int i = 0; i < numStr.length() - 1; ++i){
//            int first = Integer.parseInt(numStr.substring(0, i + 1));
//            int last = Integer.parseInt(numStr.substring(i + 1, numStr.length()));
//            sum = Math.min(first + last, sum);
//        }
//        return sum;
        int[] digitsArr = new int[4];
        int index = 0;

        while (num != 0) {
            digitsArr[index++] = num % 10;
            num /= 10;
        }

        Arrays.sort(digitsArr);

        return ((digitsArr[0] * 10 + digitsArr[3]) + (digitsArr[1] * 10 + digitsArr[2]));
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
    }
}
