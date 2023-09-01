package com.leet_easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] Morze = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-."
                , "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String morze = "";
            for (int i = 0; i < word.length(); i++) {
                morze += Morze[word.charAt(i) - 'a'];
            }
            set.add(morze);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
//International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
//
//'a' maps to ".-",
//'b' maps to "-...",
//'c' maps to "-.-.", and so on.
//For convenience, the full table for the 26 letters of the English alphabet is given below:
//
//[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
//
//For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
//Return the number of different transformations among all words we have.
//
//