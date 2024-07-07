package com.Amazon.Arrrays;

import java.util.*;
import java.util.stream.IntStream;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public static int maxLength(List<String> arr) {
        int[] MAX = {0};
        backTrack(arr, "", 0, MAX);
        return MAX[0];
    }

    private static void backTrack(List<String> arr, String current, int start, int[] MAX) {
        MAX[0] = Math.max(current.length(), MAX[0]);
        IntStream.range(start, arr.size()).forEach((i) -> {
            if (isValid(current, arr.get(i)))
                backTrack(arr, current + arr.get(i), i + 1, MAX);
        });
    }

    private static boolean isValid(String currentString, String newString) {
        Set<Character> charSet = new HashSet<>();
        IntStream.range(0, currentString.length()).
                forEach((i) -> {
                    if(charSet.contains(currentString.charAt(i)))
                        return;
                    charSet.add(currentString.charAt(i));
                });
        if(charSet.size() < currentString.length())
            return false;
        return newString.chars().allMatch(ch -> charSet.add((char) ch));
    }

    public static void main(String[] args) {
        System.out.println(maxLength(List.of("aa","bb")));
    }

}
class Faster_one {
    public static int maxLength(List<String> arr) {
        int[] MAX = {0};
        backTrack(arr, "", 0, MAX);
        return MAX[0];
    }

    private static void backTrack(List<String> arr, String current, int start, int[] MAX) {
        MAX[0] = Math.max(current.length(), MAX[0]);
        IntStream.range(start, arr.size()).forEach((i) -> {
            if (isValid(current, arr.get(i)))
                backTrack(arr, current + arr.get(i), i + 1, MAX);
        });
    }

    private static boolean isValid(String currentString, String newString) {
        Set<Character> charSet = new HashSet<>();
        IntStream.range(0, currentString.length()).
                forEach((i) -> {
                    if(charSet.contains(currentString.charAt(i)))
                        return;
                    charSet.add(currentString.charAt(i));
                });
        if(charSet.size() < currentString.length())
            return false;
        return newString.chars().allMatch(ch -> charSet.add((char) ch));
    }
}