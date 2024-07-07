package com.Amazon.Arrrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(deck[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            deque.addFirst(deque.removeLast());
            deque.addFirst(deck[i]);
        }
        //we can either create a new array or change the existing since we dont need it right??but it is not recommended

        for (int i = 0; i < n; i++) {
            deck[i] = deque.removeFirst();
        }
        return deck;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }
}
//You are given an integer array deck. There is a deck of cards
// where every card has a unique integer. The integer on the ith card is deck[i].
//
//You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
//
//You will do the following steps repeatedly until all cards are revealed:
//
//Take the top card of the deck, reveal it, and take it out of the deck.
//If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
//If there are still unrevealed cards, go back to step 1. Otherwise, stop.
//Return an ordering of the deck that would reveal the cards in increasing order.
//
//Note that the first entry in the answer is considered to be the top of the deck.