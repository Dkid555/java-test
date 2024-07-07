package com.javatest.leet_easy;

public class DivisorGame {
    public boolean divisorGame(int n) {
        //0 < x < n and n % x == 0
        return n % 2 == 0;

    }
}
//Alice and Bob take turns playing a game, with Alice starting first.
//
//Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
//
//Choosing any x with 0 < x < n and n % x == 0.
//Replacing the number n on the chalkboard with n - x.
//Also, if a player cannot make a move, they lose the game.
//
//Return true if and only if Alice wins the game, assuming both players play optimally.


//If N is even, can win.
//If N is odd, will lose.
//
//Recursive Prove （Top-down)
//If N is even.
//We can choose x = 1.
//The opponent will get N - 1, which is a odd.
//Reduce to the case odd and he will lose.
//
//If N is odd,
//2.1 If N = 1, lose directly.
//2.2 We have to choose an odd x.
//The opponent will get N - x, which is a even.
//Reduce to the case even and he will win.
//
//So the N will change odd and even alternatively until N = 1.