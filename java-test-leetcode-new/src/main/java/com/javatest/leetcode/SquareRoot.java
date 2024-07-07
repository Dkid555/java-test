package com.javatest.leetcode;

import static java.lang.Math.abs;

public class SquareRoot {
    public static int sqrt(int x) {
        if (x < 2) {
            return x;
        }
        if (x == 3) {
            return 1;
        }
        //double z = x;
        int n = x;
        int i = 0;
        while (i < (int) (Math.log(x) / Math.log(2))) {
            i++;
            //n = int(Math.floor((n+(x/n))/2));
            //n = Math.foor();
            n = (n + (x / n)) / 2;

        }
        return abs(n);


    }

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(sqrt(x));

    }
}
