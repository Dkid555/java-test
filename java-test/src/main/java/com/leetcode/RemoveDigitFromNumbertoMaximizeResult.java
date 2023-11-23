package com.leetcode;

import java.math.BigInteger;

public class RemoveDigitFromNumbertoMaximizeResult {
    public String removeDigit(String number, char digit) {
        BigInteger max = BigInteger.ZERO;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                BigInteger temp = new BigInteger(number.substring(0, i) + number.substring(i + 1));
                if (temp.compareTo(max) > 0)
                    max = temp;
            }
        }
        return max.toString();
    }
}
