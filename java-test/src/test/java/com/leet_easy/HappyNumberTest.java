package com.leet_easy;

import junit.framework.TestCase;

public class HappyNumberTest extends TestCase {

    public void testNewNumber() {
        assertEquals(1, HappyNumber.newNumber(10));
    }

    public void testIsHappy() {
        assertEquals(true, HappyNumber.isHappy(19));
    }
}