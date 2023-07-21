package com.leet_easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsinaStringIII {
    public static String reverseWords(String sentence) {
        return Arrays.stream(sentence.split(" ")).
                map(i -> new StringBuilder(i).reverse().toString()).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
// Reverse words in sentence without reversing sequence of words.