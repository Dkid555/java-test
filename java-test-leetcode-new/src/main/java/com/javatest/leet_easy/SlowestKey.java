package com.javatest.leet_easy;

import java.util.PriorityQueue;

public class SlowestKey {
    private static class Pair {
        Character character;
        int time;

        Pair(Character c, int time) {
            this.character = c;
            this.time = time;
        }
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        PriorityQueue<Pair> minPQ = new PriorityQueue<>((p1, p2) ->
                p1.time == p2.time ? p1.character.compareTo(p2.character) : p1.time - p2.time
        );
        minPQ.add(new Pair(keysPressed.charAt(0), releaseTimes[0]));
        for (int i = 1; i < keysPressed.length(); i++) { // Time complexity: N * log (2) -> N (where 2 size of PQ)
            minPQ.add(new Pair(keysPressed.charAt(i), releaseTimes[i] - releaseTimes[i - 1]));
            minPQ.poll();
        }

        return minPQ.peek().character;
    }
//    public static char slowestKey(int[] releaseTimes, String keysPressed) {
//        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
//        int max = Integer.MIN_VALUE;
//        int prev = releaseTimes[0];
//        PriorityQueue<Character> first = new PriorityQueue<>(Collections.reverseOrder());
//        first.add(keysPressed.charAt(0));
//        map.put(prev, first);
//        for (int i = 1; i < releaseTimes.length; i++){
//            int time =  releaseTimes[i] - prev;
//            PriorityQueue<Character> temp =  map.getOrDefault(time, new PriorityQueue<>(Collections.reverseOrder()));
//            temp.add(keysPressed.charAt(i));
//            map.put(time, temp);
//            prev = releaseTimes[i];
//            max = Math.max(max, time);
//        }
//        return map.get(max).poll();
//    }

    public static void main(String[] args) {
        System.out.println(slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
    }


    public char slowestKey2(int[] releaseTimes, String keysPressed) {

        int longestPressedKeyIndex = 0;
        int longestPressTime = releaseTimes[0];


        for (int i = 1; i < releaseTimes.length; i++) {
            int pressedDuration = releaseTimes[i] - releaseTimes[i - 1];

            if (pressedDuration > longestPressTime ||
                    (pressedDuration == longestPressTime && keysPressed.charAt(i) > keysPressed.charAt(longestPressedKeyIndex))) {
                longestPressTime = pressedDuration;
                longestPressedKeyIndex = i;
            }
        }

        return keysPressed.charAt(longestPressedKeyIndex);
    }
}
//A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.
//
//You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed
// in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the
// ith key was released. Both arrays are 0-indexed. The 0th key was pressed at the time 0, and every
// subsequent key was pressed at the exact time the previous key was released.
//
//The tester wants to know the key of the keypress that had the longest duration.
// The ith keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].
//
//Note that the same key could have been pressed multiple times during the test,
// and these multiple presses of the same key may not have had the same duration.
//
//Return the key of the keypress that had the longest duration. If there are multiple such keypresses,
// return the lexicographically largest key of the keypresses.