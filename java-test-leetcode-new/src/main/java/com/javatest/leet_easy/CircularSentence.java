package com.javatest.leet_easy;

public class CircularSentence {

    public static boolean isCircularSentence(String sentence) {
        String[] array = sentence.split(" ");
        char first = array[0].charAt(0);
        char end = array[0].charAt(array[0].length() - 1);
        for (int i = 1; i < array.length; i++) {
            if ((end ^ array[i].charAt(0)) != 0)
                return false;
            end = array[i].charAt(array[i].length() - 1);
        }
        return (first ^ end) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
    }
}
//A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
//
//For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
//Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.
//
//A sentence is circular if:
//
//The last character of a word is equal to the first character of the next word.
//The last character of the last word is equal to the first character of the first word.
//For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul"
// are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.
//
//Given a string sentence, return true if it is circular. Otherwise, return false.