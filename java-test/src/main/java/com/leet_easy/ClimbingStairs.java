package com.leet_easy;

/*
* You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
* */
public class ClimbingStairs {
    //Recursion method (comes to the last) O(2^n)
    static int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
/*
* This problem is the same as the Fibonacci number sequence, where the number of ways is the sum of the ways for 'n - 1' and 'n - 2'.

When we are on step i, we can only be at i + 1 or i + 2 for one iteration.

Conversely, when we are at step n, we can only have taken the route from i - 1 or i - 2.

The same applies to the route to arrive at i - 1 and i - 2 respectively.

Thus, ways(n) = ways(n - 1) + ways(n - 2).

Here, we use the iterative and tabulation method, using an array to keep track.

Note that it is possible to use only two variables to keep track of ways(i - 1) and ways(i - 2), but this is a good practice for the tabulation method in dynamic programming.*/

    //O(n), plus we can replace table with three vars
    static int climbStairs2(int n) {
        if (n == 1 || n == 2) return n;
        int[] table = new int[n + 1];
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    static int climbStairs3(int n) {
        if (n == 1 || n == 2) return n;
        int prev1 = 1, prev2 = 2, now = 0;
        for (int i = 3; i <= n; i++) {
            now = prev1 + prev2;
            prev1 = prev2;
            prev2 = now;
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(7));
        System.out.println(climbStairs3(7));
    }
}
