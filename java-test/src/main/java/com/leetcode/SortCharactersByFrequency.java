package com.leetcode;

import java.util.Arrays;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        int[] frequency = new int[128];
        int maxFreq = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            frequency[ch]++;
            maxFreq = Math.max(frequency[ch], maxFreq);
        }

        StringBuilder[] Buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i < frequency.length; ++i){
            if(frequency[i] != 0){
                if(Buckets[frequency[i]] == null)
                    Buckets[frequency[i]] = new StringBuilder();
                Buckets[frequency[i]].append(String.valueOf((char) i).repeat(frequency[i]));
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = Buckets.length - 1; i >= 0; --i){
            if(Buckets[i] != null)
                result.append(Buckets[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
//Given a string s, sort it in decreasing order based on
// the frequency of the characters. The frequency of a character
// is the number of times it appears in the string.
//
//Return the sorted string. If there are multiple answers, return any of them.