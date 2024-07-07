package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReformatTheString {
    public static String reformat(String s) {
        if (s.length() == 1)
            return s;
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                List<Character> temp = map.getOrDefault(0, new ArrayList<>());
                temp.add(ch);
                map.put(0, temp);
            } else {
                List<Character> temp = map.getOrDefault(1, new ArrayList<>());
                temp.add(ch);
                map.put(1, temp);
            }
        }
        if (!map.containsKey(0) || !map.containsKey(1))
            return "";
        List<Character> nums = map.get(0);
        List<Character> characters = map.get(1);
        int lenNums = nums.size();
        int lenCharacters = characters.size();
        if (lenNums > lenCharacters + 1 || lenNums < lenCharacters - 1 || lenCharacters > lenNums + 1 || lenCharacters < lenNums - 1) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        if (lenNums > lenCharacters) {
            for (int i = 0; i < lenCharacters; ++i) {
                result.append(nums.get(i)).append(characters.get(i));
            }
            result.append(nums.get(lenNums - 1));
        } else if (lenNums < lenCharacters) {
            for (int i = 0; i < lenNums; ++i) {
                result.append(characters.get(i)).append(nums.get(i));
            }
            result.append(characters.get(lenCharacters - 1));
        } else {
            for (int i = 0; i < lenNums; ++i) {
                result.append(characters.get(i)).append(nums.get(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformat("leetcod12345678"));
    }

}

