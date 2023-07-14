package com.leet_easy;


//You are playing the following Nim Game with your friend:
//
//Initially, there is a heap of stones on the table.
//You and your friend will alternate taking turns, and you go first.
//On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
//The one who removes the last stone is the winner.
//Given n, the number of stones in the heap, return true if you can win
// the game assuming both you and your friend play optimally, otherwise return false.
public class NimGame {
    public static boolean canWinNim(int n) {
        //because in case of fastest way,
        // if after all moves there will
        // be from 1 to 3 rocks you will be able to pick it

        return n % 4 > 0;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(1));
    }
}


//the base case: when n = 4, as suggested by the hint from the problem,
// no matter which number that that first player,
// the second player would always be able to pick the remaining number.
//
//For 1* 4 < n < 2 * 4, (n = 5, 6, 7), the first player can reduce
// the initial number into 4 accordingly, which will leave the death
// number 4 to the second player. i.e. The numbers 5, 6, 7 are winning numbers for any player who got it first.
//
//Now to the beginning of the next cycle, n = 8, no matter which number
// that the first player picks, it would always leave the winning numbers (5, 6, 7)
// to the second player. Therefore, 8 % 4 == 0, again is a death number.
//
//Following the second case, for numbers between (2*4 = 8) and (3*4=12),
// which are 9, 10, 11, are winning numbers for the first player again,
// because the first player can always reduce the number into the death number 8.