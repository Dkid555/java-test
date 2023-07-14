package com.leet_easy;

import java.util.Arrays;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            if (h < piles[0]) return (piles[0] % h == 0) ? piles[0] / h : piles[0] / h + 1;
            else return 1;
        }
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {// надо двигать влево, чтобы увеличивать количество бананов за раз
            int mid = left + (right - left) / 2;
            // количество бананов за ход, априори >/= половина от максимума
            int time = 0;
            for (int bananas : piles) {
                time += bananas % mid == 0 ? bananas / mid : (bananas / mid) + 1;
                // количество ходов необходимое для поедания всех бананов в ячейке, при заданном количестве баннанов
            }
            if (time > h) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }
}


//Koko loves to eat bananas. There are n piles of bananas,
// the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour,
// she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.

