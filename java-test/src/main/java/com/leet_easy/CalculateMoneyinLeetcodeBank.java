package com.leet_easy;

public class CalculateMoneyinLeetcodeBank {

    public static int totalMoney(int n) {
        int[] total = new int[n + 1];
        total[1] = 1;
        int sum = total[1];
        int increase = 1;
        for (int i = 2; i < n + 1; i++) {
            if ((i - 1) % 7 == 0) total[i] = ++increase;
            else total[i] += total[i - 1] + 1;
            sum += total[i];
        }
        return sum;
    }

    public static int totalMoney2(int n) {
        int extra = n % 7, weeks = n / 7;
        //1+2+3+4+5+6+7 = 28
        return 28 * weeks + 7 * (weeks) * (weeks - 1) / 2 + weeks * extra + (extra) * (extra + 1) / 2;

        //Now, weeks which is 0-based row value of n, also represents total number of previous rows.
        // Hence the formulae 28*(weeks) calculates total base sum of all previous rows.
        //7 * weeks*(weeks-1)/2 gives extra sum of all previous rows.

        // 1,  2,  3,  4,  5,  6,  7,
        // 2,  3,  4,  5,  6,  7,  8,
        // 3,  4,  5,  6,  7,  8,  9,
        // 4,  5,  6,  7,  8,  9, 10,

        // they all can be devided by 7
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney2(4));
    }
}

//Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
//
//He starts by putting in $1 on Monday, the first day.
// Every day from Tuesday to Sunday,
// he will put in $1 more than the day before.
// On every subsequent Monday, he will put in $1 more than the previous Monday.
//Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.