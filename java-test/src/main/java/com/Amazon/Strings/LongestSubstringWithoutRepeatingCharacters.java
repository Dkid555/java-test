package com.Amazon.Strings;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new ArrayDeque<>();
        int max_len = 0;
        for(int i = 0; i < s.length();++i){
            char current = s.charAt(i);
            if(set.contains(current)){
                while (!queue.isEmpty()){
                    char prev = queue.poll();
                    if(prev == current)
                        break;
                    set.remove(prev);
                }
            }
            set.add(current);
            queue.add(current);
            max_len = Math.max(max_len, queue.size());
        }
        return max_len;
    }
}
