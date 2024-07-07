package com.Amazon;

public class WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target)
            return false;
        if (x == target || y == target || target % (x + y) == 0)
            return true;
        return target % GCD(x, y) == 0;
    }

    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
