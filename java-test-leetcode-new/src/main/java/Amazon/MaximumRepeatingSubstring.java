package com.Amazon;

public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String add = word;
        while (sequence.contains(add)){
            ++count;
            add += word;
        }
        return count;

    }
}
//For a string sequence, a string word is k-repeating if word concatenated
// k times is a substring of sequence. The word's maximum k-repeating value
// is the highest value k where word is k-repeating in sequence. If word is not
// a substring of sequence, word's maximum k-repeating value is 0.
//
//Given strings sequence and word, return the maximum k-repeating value of word in sequence.
//
//