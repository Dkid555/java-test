package com.Amazon;

public class NumberofDigitOne {
    public int countDigitOne(int n) {
        int count = 0;

        for (long digit = 1; digit <= n; digit *= 10) {
            long before = n / digit, after = n % digit;
            count += (int) ((before + 8) / 10 * digit);
            if (before % 10 == 1) {
                count += (int) (after + 1);
            }
        }

        return count;
    }
}
