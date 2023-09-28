package com.leet_easy;


import java.util.Arrays;

public class NumberofLinesToWriteString {
    public static int[] numberOfLines(int[] widths, String s) {

        // width = 2...10
        int[] result = new int[2];
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int width = widths[s.charAt(i) - 'a'];
            length += width;
            if (length > 100) {
                result[0]++;
                length = 0;
                i--;
            }
        }
        result[0]++;
        result[1] = length;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa")));
    }
}
//You are given a string s of lowercase English letters and an array widths
// denoting how many pixels wide each lowercase English letter is. Specifically,
// widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.
//
//You are trying to write s across several lines, where each line is no longer than 100 pixels.
// Starting at the beginning of s, write as many letters on the first line such that the total
// width does not exceed 100 pixels. Then, from where you stopped in s, continue writing as many
// letters as you can on the second line. Continue this process until you have written all of s.
//
//Return an array result of length 2 where:
//
//result[0] is the total number of lines.
//result[1] is the width of the last line in pixels.