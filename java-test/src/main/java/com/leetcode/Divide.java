package com.leetcode;

public class Divide {
    static int Div(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        long dd = Math.abs((long) dividend), dv = Math.abs((long) divisor);
        int res = 0;

        while (dv <= dd) {
            long sum = dv, count = 1;
            while (sum <= dd - sum) {
                sum += sum;
                count += count;
            }
            res += count;
            dd -= sum;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) return -res;

        return res;

    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = -1;
        System.out.println(Div(dividend, divisor));
    }
}
