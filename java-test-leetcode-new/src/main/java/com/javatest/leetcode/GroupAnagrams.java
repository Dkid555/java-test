package com.javatest.leetcode;

import java.util.*;

//Given an array of strings strs, group
// the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging
// the letters of a different word or phrase,
// typically using all the original letters exactly once.

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> sorted = new ArrayList<>(List.of(strs));
        SortInside(sorted);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            List<Integer> temp = map.getOrDefault(sorted.get(i), new ArrayList<>());
            temp.add(i);
            map.put(sorted.get(i), temp);
        }
        for (String key : map.keySet()) {
            List<String> temp = new ArrayList<>();
            for (int index : map.get(key)
            ) {
                temp.add(strs[index]);
            }
            result.add(temp);
        }
        return result;
    }


    //works only if there are no words such "duh" and "ill" (sum of bytes are the same - 321)
    public static List<List<String>> groupAnagrams_byte(String[] strs) {
        List<List<String>> result = new ArrayList<>();
//        List<String> sorted = new ArrayList<>(List.of(strs));
//        SortInside(sorted);

        List<Integer> sumofBytes = sumOFBytes(List.of(strs));
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < sumofBytes.size(); i++) {
            List<Integer> temp = map.getOrDefault(sumofBytes.get(i), new ArrayList<>());
            temp.add(i);
            map.put(sumofBytes.get(i), temp);
        }
        for (Integer key : map.keySet()) {
            List<String> temp = new ArrayList<>();
            for (int index : map.get(key)
            ) {
                temp.add(strs[index]);
            }
            result.add(temp);
        }
        return result;
    }


    public static List<Integer> sumOFBytes(List<String> arr) {
        List<Integer> sum = new ArrayList<>();
        for (String val : arr) {
            byte[] b = val.getBytes();
            int s = 0;
            for (byte x : b
            ) {
                s += x;
            }
            sum.add(s);
        }
        return sum;
    }

    public static void SortInside(List<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            char[] ch = arr.get(i).toCharArray();
            Arrays.sort(ch);
            arr.set(i, String.valueOf(ch));
        }
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams_byte(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        String a = "duh";

        System.out.println(Arrays.toString(a.getBytes()));

        String b = "ill";
        System.out.println(Arrays.toString(b.getBytes()));
    }
}
