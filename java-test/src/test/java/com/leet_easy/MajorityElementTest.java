package com.leet_easy;

import junit.framework.TestCase;

public class MajorityElementTest extends TestCase {

    public void testMajorityElement1() {
        assertEquals(2, MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public void testMajorityElement2() {
        assertEquals(3, MajorityElement.majorityElement(new int[]{3, 2, 3}));
    }

    public void testMajorityElement3() {
        assertEquals(5, MajorityElement.majorityElement(new int[]{6, 5, 5}));
    }

}