package com.javatest.leet_easy;

public class GuessGame {
    static int Picked = 8;

    public static int guess(int num) {
        return Integer.compare(Picked, num);

        //return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}

class Sol extends GuessGame {
    public static int guessNumber(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        if (guess(n) == 0) return n;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (guess(mid) == 1) start = mid + 1;
            else if (guess(mid) == 0) return mid;
            else end = mid - 1;

        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(20));
    }
}

//We are playing the Guess Game. The game is as follows:
//
//I pick a number from 1 to n. You have to guess which number I picked.
//
//Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//
//You call a pre-defined API int guess(int num), which returns three possible results:
//
//-1: Your guess is higher than the number I picked (i.e. num > pick).
//1: Your guess is lower than the number I picked (i.e. num < pick).
//0: your guess is equal to the number I picked (i.e. num == pick).
//Return the number that I picked.