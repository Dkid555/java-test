package com.leetcode;

import java.util.*;
//

public class DeveloperTestIntegration {
    //    You are given an array of sizes of a string, q, that consists
//    of the characters "D" and "T" and integers d and t. For each size, you are
//    asked for the number of strings that can be created such that fewer than d "D"s can be next
//    to each other and fewer than t "T"s can be next to each other. For example, if you are given d=3, t=2, and [4],
//    then the possible arrangements for size 4 would be
//"DDTD"
//"TDDT"
//"DTDD"
//"TDTD"
//"DTDT"
//
//The function should then output [5]. In this case, only 2 D's can be next to each
// other and only T's can only stay by themselves.(Note the problem statement says fewer not less than equal to)
    public static List<Integer> formTeam(int d, int t, List<Integer> q) {
        int max = 0;

        for (Integer n : q)
            max = Math.max(max, n);

        List<Integer> result = new ArrayList<>();
        long[] temp = new long[max + 1];

        int mod = 1000000007;

        Deque<Long> D = new LinkedList<>();
        Deque<Long> T = new LinkedList<>();

        D.addFirst(1L);
        T.addFirst(1L);

        long tsum = 1, dsum = 1;

        temp[1] = 2;

        for (int i = 2; i <= max; i++) {
            D.addFirst(tsum);
            T.addFirst(dsum);

            long pred = dsum;
            long pret = tsum;

            dsum += pret;
            dsum %= mod;

            tsum += pred;
            tsum %= mod;

            if (D.size() > d - 1) {
                long last = D.removeLast();
                dsum -= last;

                if (dsum < 0)
                    dsum += mod;
            }

            if (T.size() > t - 1) {
                long last = T.removeLast();
                tsum -= last;

                if (tsum < 0)
                    tsum += mod;
            }

            dsum %= mod;
            tsum %= mod;

            temp[i] = (dsum + tsum) % mod;

        }
        for (int n : q) {
            result.add((int) (temp[n]));
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> q = new ArrayList<>();
        Collections.addAll(q, 2, 3, 4, 5);
        System.out.println(q);
        System.out.println(formTeam(3, 4, q));
    }
}
