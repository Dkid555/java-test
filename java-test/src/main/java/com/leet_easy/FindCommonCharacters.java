package com.leet_easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public static List<String> commonChars(String[] words) {
        if (words.length == 1) {
            return List.of(words[0].split(""));
        }
        List<String> result = new ArrayList<>();
        List<Map<Character, Integer>> listOfMaps = new ArrayList<>();
        // 1-st word as start
        Map<Character, Integer> FirstWordMap = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            FirstWordMap.put(words[0].charAt(i), FirstWordMap.getOrDefault(words[0].charAt(i), 0) + 1);
        }
        listOfMaps.add(FirstWordMap);
        for (int index = 1; index < words.length; index++) {
            Map<Character, Integer> NextWordMap = new HashMap<>();
            Map<Character, Integer> PreviousWordMap = listOfMaps.get(index - 1);
            for (int i = 0; i < words[index].length(); i++) {
                if (PreviousWordMap.containsKey(words[index].charAt(i))) {
                    NextWordMap.put(words[index].charAt(i), NextWordMap.getOrDefault(words[index].charAt(i), 0) + 1);
                    PreviousWordMap.put(words[index].charAt(i), PreviousWordMap.get(words[index].charAt(i)) - 1);
                    if (PreviousWordMap.get(words[index].charAt(i)) <= 0) {
                        PreviousWordMap.remove(words[index].charAt(i));
                        if (PreviousWordMap.isEmpty())
                            break;
                    }

                }
            }
            listOfMaps.add(NextWordMap);
        }
        for (Character letter : listOfMaps.get(listOfMaps.size() - 1).keySet()) {
            for (int i = 0; i < listOfMaps.get(listOfMaps.size() - 1).get(letter); i++) {
                result.add(letter.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
    }
}
