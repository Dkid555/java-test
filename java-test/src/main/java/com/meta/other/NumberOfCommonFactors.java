package com.meta.other;

public class NumberOfCommonFactors {
    public static int commonFactors(int a, int b) {
        if (a > b) {
            return commonFactors(b, a);
        }
        int count = 0;
        for (int i = 1; i <= a / 2; ++i) {
            if (a % i == 0 && b % i == 0)
                ++count;
        }
        if (b % a == 0)
            ++count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));
    }

}
