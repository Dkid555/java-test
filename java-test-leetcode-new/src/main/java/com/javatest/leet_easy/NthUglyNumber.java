package com.javatest.leet_easy;

public class NthUglyNumber {
    static int nthUglyNumber(int n) {
//        List<Integer> list = new ArrayList<>();
        int[] list = new int[n];
        list[0] = 1;
        int x = 0, y = 0, z = 0;
        for (int i = 1; i < n; i++) {
            list[i] = Math.min(list[x] * 2, Math.min(list[y] * 3, list[z] * 5));
            if (list[i] == 2 * list[x]) x++;
            if (list[i] == 3 * list[y]) y++;
            if (list[i] == 5 * list[z]) z++;
        }
        return list[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
