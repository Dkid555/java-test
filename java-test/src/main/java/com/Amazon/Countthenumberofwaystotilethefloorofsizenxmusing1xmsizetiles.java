package com.Amazon;

public class Countthenumberofwaystotilethefloorofsizenxmusing1xmsizetiles {

    public static void main(String[] args) {
        System.out.println(countWays(10, 3));
    }
    static int countWays(int n, int m)
    {
        // table to store values
        // of subproblems
        int[] count = new int[n + 1];

        // Fill the table upto value n
        int i;
        for (i = 1; i <= n; i++) {

            // recurrence relation
            if (i > m)
                count[i] = count[i - 1] + count[i - m];

                // base cases
            else if (i < m || i == 1)
                count[i] = 1;

                // i = = m
            else
                count[i] = 2;
        }

        // required number of ways
        return count[n];
    }
}
//Given a floor of size n x m and tiles of size 1 x m.
// The problem is to count the number of ways to tile the given
// floor using 1 x m tiles. A tile can either be placed horizontally or vertically.
//Both n and m are positive integers and 2 < = m.
//Examples: