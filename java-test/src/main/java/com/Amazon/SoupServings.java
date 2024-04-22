package com.Amazon;

public class SoupServings {
    public double soupServings(int n) {
        if (n >= 4300)  return 1.0;

        // Scale-down n by 1/25th, since soup servings will ALWAYS be a multiple of 25.
        // This keeps the DP array smaller and more manageable.
        int ns = (n + 24) / 25;

        // Serve some soup!!!   Yum!!
        return serve(ns, ns, new double[ns + 1][ns + 1]);
    }

    private double serve(int a, int b, double[][] dp){
        if (a <= 0 && b <= 0) return 0.5;
        if (b <= 0) return 0.0;
        if (a <= 0) return 1.0;
        if (dp[a][b] > 0) return dp[a][b];
        return dp[a][b] = 0.25 * (serve(a - 4, b, dp) + serve(a - 3, b - 1, dp) +
                serve(a - 2, b - 2, dp) + serve(a - 1, b - 3, dp));
    }
}
//There are two types of soup: type A and type B. Initially, we have n ml of each type of soup.
// There are four kinds of operations:
//
//Serve 100 ml of soup A and 0 ml of soup B,
//Serve 75 ml of soup A and 25 ml of soup B,
//Serve 50 ml of soup A and 50 ml of soup B, and
//Serve 25 ml of soup A and 75 ml of soup B.
//When we serve some soup, we give it to someone, and we no longer have it.
// Each turn, we will choose from the four operations with an equal probability 0.25.
// If the remaining volume of soup is not enough to complete the operation,
// we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.
//
//Note that we do not have an operation where all 100 ml's of soup B are used first.
//
//Return the probability that soup A will be empty first, plus half the probability
// that A and B become empty at the same time. Answers within 10-5 of the actual answer will be accepted.