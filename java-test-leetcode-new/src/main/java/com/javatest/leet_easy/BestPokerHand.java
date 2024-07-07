package com.javatest.leet_easy;

import java.util.HashMap;
import java.util.Map;

public class BestPokerHand {
    public static String bestHand(int[] ranks, char[] suits) {
        Map<Character, Integer> suit = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        int max = 0;
        for (int i = 0; i < ranks.length; i++) {
            suit.put(suits[i], suit.getOrDefault(suits[i], 0) + 1);
            if (suit.get(suits[i]) == 5) return "Flush";
            rank.put(ranks[i], rank.getOrDefault(ranks[i], 0) + 1);
            max = Math.max(max, rank.get(ranks[i]));
        }
//        int max = rank.values().stream().max(Integer::compareTo).get();
        if (max >= 3) return "Three of a Kind";
        return max == 2 ? "Pair" : "High Card";
    }

    public static void main(String[] args) {
        System.out.println(bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
        System.out.println(bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'}));
    }
}

//You are given an integer array ranks and a character array suits.
// You have 5 cards where the ith card has a rank of ranks[i] and a suit of suits[i].
//
//The following are the types of poker hands you can make from best to worst:
//
//"Flush": Five cards of the same suit.
//"Three of a Kind": Three cards of the same rank.
//"Pair": Two cards of the same rank.
//"High Card": Any single card.
//Return a string representing the best type of poker hand you can make with the given cards.
//
//Note that the return values are case-sensitive.