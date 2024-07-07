package com.javatest.leetcode;

public class NthDigit {
    public static int findNthDigit(int n) {
        int start = 1;
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() < n)
            stringBuilder.append(start++);
        return stringBuilder.charAt(n - 1) - '0';
    }

    public int findNthDigit2(int n) {
        int len = 1;
        long start = 1;
        long end = 10;
        while (n > (end - start) * len) {
            n -= (end - start) * len;
            end *= 10;
            start *= 10;
            len++;
        }
        long targetNum = start + ((n - 1) / len);
        int index = (n - 1) % len;
        String s = String.valueOf(targetNum);
        return s.charAt(index) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
    }
}
