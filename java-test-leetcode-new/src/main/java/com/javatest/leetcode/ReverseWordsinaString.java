package com.javatest.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters.
// The words in s will be separated by at least one space.
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces
// or multiple spaces between two words.
// The returned string should only have a single space
// separating the words. Do not include any extra spaces.
public class ReverseWordsinaString {
    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        String result = "";
        s = s.replaceAll("\\s+", " ");
        Collections.addAll(list, s.split(" "));
        for (int i = list.size() - 1; i != -1; i--) {
            result += list.get(i) + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" a good   example "));
    }
}
