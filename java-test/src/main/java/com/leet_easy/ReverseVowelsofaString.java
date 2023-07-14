package com.leet_easy;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReverseVowelsofaString {

    public static String reverseVowels(String str) {
        Stack<Character> vowels = new Stack<>();
        Set<Character> set = Stream.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U').collect(Collectors.toSet());

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) vowels.push(str.charAt(i));
        }
        if (!vowels.isEmpty()) {
            StringBuilder str1 = new StringBuilder(str);
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i))) str1.setCharAt(i, vowels.pop());
            }
            return str1.toString();
        }
        return str;
    }

    // with switchcase
    public static String reverseVowels2(String str) {
        Stack<Character> vowels = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a' -> vowels.push('a');
                case 'A' -> vowels.push('A');
                case 'e' -> vowels.push('e');
                case 'E' -> vowels.push('E');
                case 'i' -> vowels.push('i');
                case 'I' -> vowels.push('I');
                case 'o' -> vowels.push('o');
                case 'O' -> vowels.push('O');
                case 'u' -> vowels.push('u');
                case 'U' -> vowels.push('U');
            }
        }
        char[] arr = str.toCharArray();
        if (!vowels.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case 'a' -> arr[i] = vowels.pop();
                    case 'A' -> arr[i] = vowels.pop();
                    case 'e' -> arr[i] = vowels.pop();
                    case 'E' -> arr[i] = vowels.pop();
                    case 'i' -> arr[i] = vowels.pop();
                    case 'I' -> arr[i] = vowels.pop();
                    case 'o' -> arr[i] = vowels.pop();
                    case 'O' -> arr[i] = vowels.pop();
                    case 'u' -> arr[i] = vowels.pop();
                    case 'U' -> arr[i] = vowels.pop();
                }
            }
        }
        return String.valueOf(arr);
    }

    public static String reverseVowels3(String str) {
        int begin = 0;
        char[] string = str.toCharArray();
        int end = str.length() - 1;
        while (begin < end) {
            if (check(string[begin]) && check(string[end])) {
                char temp = string[begin];
                string[begin] = string[end];
                string[end] = temp;
                begin++;
                end--;
            }
            while (!check(string[begin]) && begin < end) {
                begin++;
            }
            while (!check(string[end]) && end > begin) {
                end--;
            }
        }

        return String.valueOf(string);
    }

    private static boolean check(char c) {
        switch (c) {
            case 'a' -> {
                return true;
            }
            case 'A' -> {
                return true;
            }
            case 'e' -> {
                return true;
            }
            case 'E' -> {
                return true;
            }
            case 'i' -> {
                return true;
            }
            case 'I' -> {
                return true;
            }
            case 'o' -> {
                return true;
            }
            case 'O' -> {
                return true;
            }
            case 'u' -> {
                return true;
            }
            case 'U' -> {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels3("Leetcode"));
    }
}
