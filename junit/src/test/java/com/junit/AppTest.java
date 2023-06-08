package com.junit;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testAdd() {
        var calc = new App();
        assertEquals(8, calc.add(4, 4));
    }

    public void testMin() {
        var calc = new App();
        assertEquals(3, calc.min(3, 4));
    }

    public void testMax() {
        var calc = new App();
        assertEquals(6, calc.max(6, 5));
    }
}