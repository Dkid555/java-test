package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return helper(0, num, new ArrayList<>());
    }

    private boolean helper(int curIdx, String num, List<String> result) {
        if (curIdx == num.length() && result.size() >= 3) {
            return true;
        }
        for (int i = curIdx; i < num.length(); i++) {
            if (i != curIdx && num.charAt(curIdx) == '0') {
                break;
            }
            String curNum = num.substring(curIdx, i + 1);
            if (result.size() <= 1 || curNum.equals(
                    String.valueOf(
                            Long.parseLong(result.get(result.size() - 1)) + Long.parseLong(result.get(result.size() - 2)))
            )) {
                result.add(curNum);
                if (helper(i + 1, num, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}
//An additive number is a string whose digits can form an additive sequence.
//
//A valid additive sequence should contain at least three numbers. Except for the first
// two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
//Given a string containing only digits, return true if it is an additive number or false otherwise.
//
//Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.