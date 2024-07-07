package com.javatest.leetcode;

public class FindFirstPalindromicStringintheArray {
    public String firstPalindromeO(String[] words) {
        for (String word : words){
            String reversed = new StringBuilder(word).reverse().toString();
            if(word.equals(reversed))
                return word;
        }
        return "";
    }
    public String firstPalindrome(String[] words) {
        for (String word : words){
            if(isPalindrome(word))
                return word;
        }
        return "";
    }
    private boolean isPalindrome(String word){
        int left = 0;
        int right = word.length() - 1;
        while (left < right){
            if(word.charAt(left++) != word.charAt(right--))
                return false;
        }
        return true;
    }
}
