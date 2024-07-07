package com.Amazon.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class ValidPalindrome {
    public boolean isPalindrome(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : string.toCharArray()){
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                stringBuilder.append(String.valueOf(ch).toLowerCase());
            }
        }

        int str_len = stringBuilder.length();
        if(str_len == 0) return true;
        for (int i = 0; i <= str_len/2; ++i){
            if(stringBuilder.charAt(i) != stringBuilder.charAt(str_len - i - 1))
                return false;
        }

        return true;
    }

    public static boolean isPalindrome2(String string){
        String normalized = string.chars().
                mapToObj(ch -> (Character.isDigit(ch) || Character.isLetter(ch)) ?
                        String.valueOf((char) ch).toLowerCase() : "").
        toList().stream().collect(Collectors.joining());
        return IntStream.range(0, normalized.length()/2).allMatch(i -> normalized.charAt(i) == normalized.charAt(normalized.length() - i - 1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
