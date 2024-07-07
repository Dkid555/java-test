package com.javatest.leet_easy;

public class NumberofSegmentsinaString {
    static int countSegments1(String str) {
        str = str.trim();
        return (str.isEmpty() ? 0 : str.split(" +").length);
    }

    static int countSegments2(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((i == 0 || str.charAt(i - 1) == ' ') && str.charAt(i) != ' ') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "Hello, world ";
        System.out.println(countSegments1(str));
        System.out.println(countSegments2(str));
    }
}
//Given a string s, return the number of segments in the string.
//
//A segment is defined to be a contiguous sequence of non-space characters.