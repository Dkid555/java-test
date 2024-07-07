package com.javatest.leet_easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            return !Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet()).isEmpty() && s.length() > 1;
        }
        int count = 0;
        char temp = 0;
        char temp2;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count == 2) {
                    temp2 = s.charAt(i);
                    s = s.substring(0, i) + temp + s.substring(i + 1);
                    s = s.substring(0, index) + temp2 + s.substring(index + 1);
                    break;
                }
                index = i;
                temp = s.charAt(i);
            }
        }
        return count == 2 && s.equals(goal);
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("abcab", "abcba"));
    }
}
