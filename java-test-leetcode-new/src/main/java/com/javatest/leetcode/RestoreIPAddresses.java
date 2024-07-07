package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i < 4 && i < n; i++)
            for (int j = i + 1; j < i + 4 && j < n; j++)
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String seg1 = s.substring(0, i),
                            seg2 = s.substring(i, j),
                            seg3 = s.substring(j, k),
                            seg4 = s.substring(k, n);
                    if (check(seg1) && check(seg2) && check(seg3) && check(seg4))
                        result.add(seg1 + '.' + seg2 + '.' + seg3 + '.' + seg4);
                }
        return result;
    }

    private static boolean check(String str) {
        return str.length() <= 3 &&
                str.length() != 0 &&
                (str.charAt(0) != '0' || str.length() <= 1) &&
                Integer.parseInt(str) <= 255;
    }

    public static List<String> restoreIpAddresses2(String s) {
        List<String> result = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backTrack(String str, int start, List<String> current, List<String> result) {
        if (start == str.length() && current.size() == 4) {
            result.add(String.join(".", current));
            return;
        }
        if (current.size() >= 4)
            return;
        for (int i = 1; i <= 3; i++) // we have a limit of numbers per chunk - 3
            if (start + i <= str.length()) {
                String segment = str.substring(start, start + i);
                if (check(segment)) {
                    current.add(segment);
                    backTrack(str, start + i, current, result);
                    current.remove(current.size() - 1);
                }
            }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses2("25525511135"));
    }
}
//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
//For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
// but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//Given a string s containing only digits, return all possible valid IP addresses
// that can be formed by inserting dots into s. You are not allowed to reorder
// or remove any digits in s. You may return the valid IP addresses in any order.