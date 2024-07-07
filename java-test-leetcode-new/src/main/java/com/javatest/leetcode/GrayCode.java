package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (n == 0)
            return list;
        list.add(1);
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr *= 2;
            for (int j = list.size() - 1; j >= 0; j--)
                list.add(curr + list.get(j));
        }
        return list;

    }
}
//An n-bit gray code sequence is a sequence of 2n integers where:
//
//Every integer is in the inclusive range [0, 2n - 1],
//The first integer is 0,
//An integer appears no more than once in the sequence,
//The binary representation of every pair of adjacent integers differs by exactly one bit, and
//The binary representation of the first and last integers differs by exactly one bit.
//Given an integer n, return any valid n-bit gray code sequence.