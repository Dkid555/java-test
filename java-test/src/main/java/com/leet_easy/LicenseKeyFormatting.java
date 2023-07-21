package com.leet_easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String s, int k) {
//        s = s.replace("-", "");
        int count = 1;
        List<Character> res = new ArrayList<>();
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) != '-') {
                if (count <= k) {
                    res.add(s.charAt(i));
                    count++;
                } else {
                    count = 1;
                    res.add('-');
                    i++;
                }
            }
        }
        return new StringBuilder(res.stream()
                .map(n -> String.valueOf(n).toUpperCase())
                .collect(Collectors.joining("", "", ""))).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting2("2-5g-3-J", 2));
    }

// just 2

    public static String licenseKeyFormatting2(String s, int k) {
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) != '-') {
                if (count <= k) {
                    result.append(String.valueOf(s.charAt(i)).toUpperCase());
                    count++;
                } else {
                    count = 1;
                    result.append('-');
                    i++;
                }
            }
        }
        return result.reverse().toString();
    }
}


///You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
// The string is separated into n + 1 groups by n dashes. You are also given an integer k.
//
//We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
//
//Return the reformatted license key.
