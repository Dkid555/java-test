package com.javatest.leet_easy;

public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        int length1 = 0;
        int length2 = 0;
        String result = "";
        while (length1 < word1.length() && length2 < word2.length()) {
            result += (String.valueOf(word1.charAt(length1++)) + String.valueOf(word2.charAt(length2++)));
        }
        if (length1 < word1.length()) {
            result += word1.substring(length1);
        } else if (length2 < word2.length()) {
            result += word2.substring(length2);
        }
        return result;
    }

    public static String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (i = 0; i < word1.length() && i < word2.length(); i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        result.append(word1.substring(i));
        result.append(word2.substring(i));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqrsw"));
    }
}
