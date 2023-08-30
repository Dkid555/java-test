package com.leet_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord {


    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] par = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = Arrays.stream(banned).collect(Collectors.toSet());
        int max = Integer.MIN_VALUE;
        String result = "";
        for (String word : par) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (max < map.get(word)) {
                    result = word;
                    max = map.get(word);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));
    }
}
