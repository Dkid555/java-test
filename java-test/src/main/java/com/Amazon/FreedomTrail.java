package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class FreedomTrail {

    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "gd"));
    }


    public static int findRotateSteps(String ring, String key) {
        char[] r = ring.toCharArray();
        List<Integer>[] positions = new List[26];

        // Store the positions of each character in the ring
        for (int i = 0; i < r.length; i++) {
            int c = r[i] - 'a';
            if (positions[c] == null) positions[c] = new ArrayList<>();
            positions[c].add(i);
        }

        // Dynamic programming memoization
        int[][] dp = new int[key.length()][r.length];

        // Start with the first character of the key at position 0
        return helper(0, 0, positions, key.toCharArray(), r, dp);
    }

    // Recursive function with memoization
    private  static int helper(int index, int pos, List<Integer>[] positions, char[] key, char[] ring, int[][] dp) {
        // If all characters of the key have been matched, return 0
        if (index == key.length) return 0;

        // If this state has already been computed, return the cached result
        if (dp[index][pos] > 0) return dp[index][pos];

        // Current character in the key
        char target = key[index];

        // List of possible positions of the current character in the ring
        List<Integer> possiblePositions = positions[target - 'a'];

        // Minimum steps required to reach the current character from the current position
        int minSteps = Integer.MAX_VALUE;

        // Iterate through possible positions and calculate minimum steps
        for (int nextPos : possiblePositions) {
            // Calculate the steps to move from the current position to the next position
            int steps = Math.min(Math.abs(nextPos - pos), ring.length - Math.abs(nextPos - pos));

            // Calculate steps for remaining characters recursively
            int totalSteps = steps + helper(index + 1, nextPos, positions, key, ring, dp);

            // Update the minimum steps
            minSteps = Math.min(minSteps, totalSteps);
        }

        // Cache the result and return
        return dp[index][pos] = minSteps + 1;
    }
}
//In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal
// dial called the "Freedom Trail Ring" and use the dial to spell a specific keyword to open the door.
//
//Given a string ring that represents the code engraved on the outer ring and another string
// key that represents the keyword that needs to be spelled, return the minimum number of steps
// to spell all the characters in the keyword.
//
//Initially, the first character of the ring is aligned at the "12:00" direction. You should spell
// all the characters in key one by one by rotating ring clockwise or anticlockwise to make each
// character of the string key aligned at the "12:00" direction and then by pressing the center button.
//
//At the stage of rotating the ring to spell the key character key[i]:
//
//You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final
// purpose of the rotation is to align one of ring's characters at the "12:00" direction,
// where this character must equal key[i].
//If the character key[i] has been aligned at the "12:00" direction, press the center button
// to spell, which also counts as one step. After the pressing, you could begin to spell the next
// character in the key (next stage). Otherwise, you have finished all the spelling.