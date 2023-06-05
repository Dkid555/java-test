package com.leet_easy;

import java.util.Arrays;

/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".*/
public class LongestComonPrefix {

    //O(nlogn + word1.length)
    static String helper(String[] strings) {
        int end = 0;
        Arrays.sort(strings);
        String word1 = strings[0];
        String word2 = strings[strings.length - 1];
        while (end < word1.length() && end < word2.length()) {
            if (word1.charAt(end) == word2.charAt(end)) end++;
            else break;
        }
        return word2.substring(0, end);
    }

    //O(n + prefix.length)
    static String pref(String[] strings) {
        if (strings.length == 0)
            return "";

        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strings = {"flowerVille", "flower", "flow"};
        System.out.println(pref(strings));
        System.out.println(helper(strings));

    }
}
