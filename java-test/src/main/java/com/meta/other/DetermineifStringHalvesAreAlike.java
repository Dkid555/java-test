package com.meta.other;

import java.util.Set;

public class DetermineifStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        if(s.length() % 2 != 0) return false;

        int count_left = 0;
        int count_right = 0;
        int left = 0;
        int right = s.length() - 1;

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        while (left < right){
            if(set.contains(s.charAt(left++)))
                ++count_left;
            if(set.contains(s.charAt(right--)))
                ++count_right;
        }
        return count_left == count_right;

    }
}
//You are given a string s of even length.
// Split this string into two halves of equal lengths,
// and let a be the first half and b be the second half.
//
//Two strings are alike if they have the same number of vowels
// ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
//
//Return true if a and b are alike. Otherwise, return false.