package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWin(0, desiredTotal, used, memo);
    }

    private static boolean canIWin(int sum, int desiredTotal, boolean[] used, Map<Integer, Boolean> memo) {
        if (sum >= desiredTotal) return false;
        int bit = bitMap(used);
        Boolean status = memo.get(bit);
        if (status != null) return status;
        // If the opponent always win or I always lose, then win is false
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                status = !canIWin(sum + i, desiredTotal, used, memo);
                used[i] = false;
                if (status) break;
            }
        }
        memo.put(bit, status);
        return status;
    }

    private static int bitMap(boolean[] used) {
        int bit = 0;
        for (boolean v : used) {
            bit <<= 1;
            if (v) {
                bit |= 1;
            }
        }
        return bit;
    }

    public static void main(String[] args) {
        System.out.println(canIWin(10, 20));
    }
}
// In the "100 game" two players take turns adding, to a running total,
// any integer from 1 to 10. The player who first causes
// the running total to reach or exceed 100 wins.
//
// What if we change the game so that players cannot re-use integers?
//
// For example, two players might take turns drawing from a
// common pool of numbers from 1 to 15 without
// replacement until they reach a total >= 100.
//
// Given two integers maxChoosableInteger and desiredTotal,
// return true if the first player to move can force a win,
// otherwise, return false. Assume both players play optimally.


class as {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWin(0, desiredTotal, used, memo, 0);
    }

    private boolean canIWin(int sum, int desiredTotal, boolean[] used, Map<Integer, Boolean> memo, int bitMap) {
        if (sum >= desiredTotal) return false;
        Boolean status = memo.get(bitMap);
        if (status != null) return status;
        // If the opponent always win or I always lose, then win is false
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                status = !canIWin(sum + i, desiredTotal, used, memo, bitMap | (1 << i));
                used[i] = false;
                if (status) break;
            }
        }
        memo.put(bitMap, status);
        return status;
    }
}