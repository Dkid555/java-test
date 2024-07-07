package com.Amazon.Strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static int minSteps(String s, String t) {
        if(t.length() != s.length())
            return -1;
        Map<Character, Integer> map_s = new HashMap<>();

        for(int i = 0; i < s.length(); ++i)
            map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
        int result = 0;
        for(int i = 0; i < t.length(); ++i){
            char ch = t.charAt(i);
            if(map_s.containsKey(ch)){
                map_s.put(ch, map_s.get(ch) - 1);
                if(map_s.get(ch) == 0)
                    map_s.remove(ch);
                continue;
            }
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minSteps("aba", "bab"));
    }
}
