package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsandRods {
    public int countPoints(String rings) {
        Set<Integer> rods = new HashSet<>();
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < rings.length(); i += 2){
            Character color = rings.charAt(i);
            Integer rod = Integer.parseInt(String.valueOf(rings.charAt(i+1)));
            Set<Character> temp = map.getOrDefault(rod, new HashSet<>());
            temp.add(color);
            if(temp.size() > 2)
                rods.add(rod);
            map.put(rod, temp);
        }
        return rods.size();
    }
}
//There are n rings and each ring is either red, green, or blue. The rings are distributed
// across ten rods labeled from 0 to 9.
//
//You are given a string rings of length 2n that describes the n rings that are placed onto the rods.
// Every two characters in rings forms a color-position pair that is used to describe each ring where:
//
//The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
//The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
//For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3,
// a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
//
//Return the number of rods that have all three colors of rings on them.