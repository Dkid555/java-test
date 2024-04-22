package com.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int digit = 1; digit < 9; ++digit) {
            int num = digit;
            int nextDigit = num + 1;
            while (num <= high && nextDigit <= 9) {
                num = (num * 10) + nextDigit;
                if (num >= low && num <= high)
                    result.add(num);
                ++nextDigit;
            }
        }

        Collections.sort(result);
        return result;
    }
}
//An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//
//Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.