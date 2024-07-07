package com.javatest.leet_easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class BinaryGap {
    public static int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        PriorityQueue<Integer> myPriority = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        int countOnes = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                countOnes++;
                myPriority.add(++count);
                count = 0;
            } else
                ++count;
            n = n >> 1;
        }
        return countOnes <= 1 ? 0 : myPriority.poll();
    }

    public int binaryGap2(int n) {
        String bin = Integer.toBinaryString(n);
        int idx = 0, max = -1;
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            if (c == '1') {
                int cur = i - idx;
                if (max < cur) {
                    max = cur;
                }
                idx = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(6));
    }
}
//Given a positive integer n, find and return the longest distance between
// any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
//
//Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
// The distance between two 1's is the absolute difference between their bit positions.
// For example, the two 1's in "1001" have a distance of 3.