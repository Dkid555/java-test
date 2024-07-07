package com.Amazon.Strings;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        // Initialising an empty array to store the count of the
        // characters in the given string s
        int[] arr = new int[26];
        int result = 0;
        int max = 0;

        // The left pointer for the sliding window is left AND r is the
        // right pointer
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Counting the number of each character in the string s
            arr[s.charAt(right) - 'A']++;

            // Checking the character with max number of occurrence
            max = Math.max(max, arr[s.charAt(right) - 'A']);

            // Now we check if our current window is valid or not
            if (right - left + 1 - max > k) {
                // this means the no. of replacements is more than
                // allowed (k)
                // Decrementing the count of the character which was
                // at left because it is no longer in the window
                arr[s.charAt(left) - 'A']--;
                left++;
            }

            // The max our window can be
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }
}
