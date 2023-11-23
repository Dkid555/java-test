package com.leetcode;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0;
        int end = minutes;
        int sum = 0;
        for (int i = 0; i < customers.length; i++)
            if (grumpy[i] == 0)
                sum += customers[i];
        int tot = 0;
        for (int i = 0; i < end; i++)
            if (grumpy[i] == 1)
                tot += customers[i];
        int n_tot = tot;
        for (int i = 0; i < customers.length - minutes; i++) {
            if (grumpy[start] == 1)
                n_tot -= customers[start];
            if (grumpy[end] == 1)
                n_tot += customers[end];
            tot = Math.max(tot, n_tot);
            start++;
            end++;
        }
        return sum + tot;
    }
}
