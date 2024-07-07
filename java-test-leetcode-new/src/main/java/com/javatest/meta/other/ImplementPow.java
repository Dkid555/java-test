package com.javatest.meta.other;

public class ImplementPow {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1 || x == 0) return x;
        double s = 1;
        while (n-- != 0)
            s *= x;

        return s;
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1 || x == 0) return x;
        long p = n;
        if (p < 0) {
            p = Math.abs(p);
            x = 1 / x;
        }
        double pow = 1;
        while (p != 0) {
            if ((p & 1) != 0) pow *= x;
            x *= x;
            p >>>= 1; // p / 2
        }
        return pow;
    }
}
