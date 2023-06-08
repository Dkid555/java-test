package com.leet_easy;

import junit.framework.TestCase;

public class FibonacciNumberTest extends TestCase {

    public void testFibonachi1() {
        int[] res = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181};
        for (int i = 0; i < 20; i++) {
            assertEquals(res[i], FibonacciNumber.Fibonachi(i));
        }
    }
}