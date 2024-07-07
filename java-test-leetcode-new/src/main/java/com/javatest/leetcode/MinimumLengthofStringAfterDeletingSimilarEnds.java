package com.javatest.leetcode;

public class MinimumLengthofStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            if(s.charAt(start) != s.charAt(end))
                break;
            ++start;
            --end;
        }
        return s.substring(start, end + 1).length();
    }
}
