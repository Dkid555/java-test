package com.javatest.leetcode;

public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        char smallest = Character.MAX_VALUE;
        for (char let : letters) {
            if (let > target && let < smallest) {
                smallest = let;
            }
        }

        return smallest != Character.MAX_VALUE ? smallest : letters[0];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }
}

//You are given an array of characters letters
// that is sorted in non-decreasing order, and a character target.
// There are at least two different characters in letters.
//
//Return the smallest character in letters that is lexicographically greater than target.
// If such a character does not exist, return the first character in letters.
