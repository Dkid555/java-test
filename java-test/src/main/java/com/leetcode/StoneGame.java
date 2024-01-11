package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StoneGame {
    public boolean stoneGame2(int[] piles) {
        return true;
    }

    public boolean stoneGame(int[] piles) {
        int aliceStones = 0;
        int bobStones = 0;

        List<Integer> list = new ArrayList<>();
        for (int pile : piles) {
            list.add(pile);
        }

        for (int round = 0; round < piles.length / 2; round++) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);

            aliceStones += Math.max(first, last);
            bobStones += Math.min(first, last);

            list.remove(0);
            list.remove(list.size() - 1);
        }

        return aliceStones > bobStones;

    }
}
