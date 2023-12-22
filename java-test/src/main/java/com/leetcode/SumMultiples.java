package com.leetcode;

public class SumMultiples {
    public int sumOfMultiples(int n) {
        int sum = 0;
        int[] listDiv = new int[]{3, 5, 7};
        for (int i = 1; i <= n; ++i) {
            for (int div : listDiv)
                if (i % div == 0) {
                    sum += i;
                    break;
                }
        }
        return sum;
    }

    public int sumOfMultiples2(int n) {
        return aps(n, 3) + aps(n, 5) + aps(n, 7) + aps(n, 105)
                - aps(n, 15) - aps(n, 21) - aps(n, 35);
    }

    private int aps(int n, int x) {
        return n / x * (n / x + 1) / 2 * x;
    }
}
