package com.leet_easy;

import junit.framework.TestCase;

public class MaximumCountTest extends TestCase {
    public void testmax1() {
        assertEquals(3, MaximumCount.maxcount_bin(new int[]{-3, -2, -1, 0, 0, 1, 2}));
    }

    public void testmax2() {
        assertEquals(4, MaximumCount.maxcount_bin(new int[]{5, 20, 66, 1314}));
    }

    public void testmax3() {
        assertEquals(3, MaximumCount.maxcount_bin(new int[]{-2, -1, -1, 1, 2, 3}));
    }

    public void testmax4() {
        assertEquals(0, MaximumCount.maxcount_bin(new int[100]));
    }

    public void testmax5() {
        assertEquals(1, MaximumCount.maxcount_bin(new int[]{-1}));
    }
}