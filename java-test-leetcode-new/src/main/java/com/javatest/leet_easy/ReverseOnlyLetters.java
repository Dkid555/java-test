package com.javatest.leet_easy;

public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        char[] temp = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (Character.isAlphabetic(temp[low]) && Character.isAlphabetic(temp[high])) {
                char letter = temp[low];
                temp[low] = temp[high];
                temp[high] = letter;
                low++;
                high--;
            } else if (!Character.isAlphabetic(temp[low])) low++;
            else if (!Character.isAlphabetic(temp[high])) high--;
        }
        return String.valueOf(temp);
    }
}
//Given a string s, reverse the string according to the following rules:
//
//All the characters that are not English letters remain in the same position.
//All the English letters (lowercase or uppercase) should be reversed.
//Return s after reversing it.