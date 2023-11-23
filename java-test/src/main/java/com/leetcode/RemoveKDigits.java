package com.leetcode;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k > 0) {
            int i = 0;
            //find the peak
            while (i < sb.length() - 1
                    && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            //delete the  peak
            sb.deleteCharAt(i);
            k--;
        }
        //remove the leading 0s
        while (sb.toString().startsWith("0")) {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.