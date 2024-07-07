package com.javatest.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {

        Map<Character, Integer> order_map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i){
            order_map.put(order.charAt(i), i);
        }
        int size = order_map.size();
        StringBuilder[] stringBuilders = new StringBuilder[size + 1];
        for (char ch : s.toCharArray()){
            int index = order_map.getOrDefault(ch, size);
            if(stringBuilders[index] == null)
                stringBuilders[index] = new StringBuilder();
            stringBuilders[index].append(ch);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < stringBuilders.length; ++i){
            if(stringBuilders[i] != null)
                result.append(stringBuilders[i]);
        }
        return result.toString();

    }
}
//You are given two strings order and s. All the
// characters of order are unique and were sorted in some custom order previously.
//
//Permute the characters of s so that they match the order
// that order was sorted. More specifically, if a character
// x occurs before a character y in order, then x should occur before y in the permuted string.
//
//Return any permutation of s that satisfies this property.