package com.leetcode;

import junit.framework.TestCase;

import java.util.Arrays;

import static com.leetcode.Temperature.waitdays;


public class TemperatureTest extends TestCase {

    public void testWaitdays1() {
        assertTrue(Arrays.equals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, waitdays(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public void testWaitdays2() {
        assertTrue(Arrays.equals(new int[]{1, 1, 1, 0}, waitdays(new int[]{30, 40, 50, 60})));
    }

    public void testWaitdays3() {
        assertTrue(Arrays.equals(new int[]{1, 1, 0}, waitdays(new int[]{30, 60, 90})));
    }
}