package com.javatest.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberofBeautifulPairs {

    public static int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int firstDigit = Integer.toString(nums[i]).charAt(0) - '0';
            for (int j = i + 1; j < nums.length; j++) {
                int lastDigit = nums[j] % 10;
                if (gcd(firstDigit, lastDigit) == 1) count++;
            }
        }
        return count;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(countBeautifulPairs2(new int[]{31, 25, 72, 79, 74}));
    }

    //// for one cycle{digits for first is 1 - 9. for last is 0 - 9}
//    1 : 0,1,2,3,4,5,6,7,8,9
//    2: 1,3,5,7,9
//    3: 1,2,4,5,7,8
//    4: 1,3,5,7,9
//    5: 1,2,3,4,6,7,8,9
//    6: 1,5,7
//    7: 1,2,3,4,5,6,8,9
//    8: 1,3,5,7,9
//    9: 1,2,4,5,7,8


    public static int countBeautifulPairs2(int[] nums) {
        int count = 0;
        Set<Integer> set1 = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 4, 5, 7, 8));
        Set<Integer> set4 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
        Set<Integer> set5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9));
        Set<Integer> set6 = new HashSet<>(Arrays.asList(1, 5, 7));
        Set<Integer> set7 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9));
        Set<Integer> set8 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
        Set<Integer> set9 = new HashSet<>(Arrays.asList(1, 2, 4, 5, 7, 8));
        for (int i = 0; i < nums.length; i++) {
            int firstDigit = Integer.toString(nums[i]).charAt(0) - '0';
            for (int j = i + 1; j < nums.length; j++) {
                int lastDig = nums[j] % 10;
                switch (firstDigit) {
                    case 1 -> count += set1.contains(lastDig) ? 1 : 0;
                    case 2 -> count += set2.contains(lastDig) ? 1 : 0;
                    case 3 -> count += set3.contains(lastDig) ? 1 : 0;
                    case 4 -> count += set4.contains(lastDig) ? 1 : 0;
                    case 5 -> count += set5.contains(lastDig) ? 1 : 0;
                    case 6 -> count += set6.contains(lastDig) ? 1 : 0;
                    case 7 -> count += set7.contains(lastDig) ? 1 : 0;
                    case 8 -> count += set8.contains(lastDig) ? 1 : 0;
                    case 9 -> count += set9.contains(lastDig) ? 1 : 0;
                }
            }
        }
        return count;
    }

}
//You are given a 0-indexed integer array nums. A pair
// of indices i, j where 0 <= i < j < nums.length is called
// beautiful if the first digit of nums[i] and the last digit
// of nums[j] are coprime.
//
//Return the total number of beautiful pairs in nums.
//
//Two integers x and y are coprime if there is no integer greater
// than 1 that divides both of them. In other words, x and y are coprime
// if gcd(x, y) == 1, where gcd(x, y) is the greatest common divisor of x and y.


class Solution213 {
    private static final int[][] COPRIMES = {
            {},                          // 0
            {1, 2, 3, 4, 5, 6, 7, 8, 9}, // 1
            {1, 3, 5, 7, 9},             // 2
            {1, 2, 4, 5, 7, 8},          // 3
            {1, 3, 5, 7, 9},             // 4
            {1, 2, 3, 4, 6, 7, 8, 9},    // 5
            {1, 5, 7},                   // 6
            {1, 2, 3, 4, 5, 6, 8, 9},    // 7
            {1, 3, 5, 7, 9},             // 8
            {1, 2, 4, 5, 7, 8}           // 9
    };

    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        int[] cntMap = new int[10];
        for (int num : nums) {
            res += getCount(cntMap, num % 10);
            cntMap[getFirstDigit(num)]++;
        }
        return res;
    }

    private int getCount(int[] cntMap, int digit) {
        int res = 0;
        for (int coprime : COPRIMES[digit]) {
            res += cntMap[coprime];
        }
        return res;
    }

    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
}