package com.junit;

/**
 * Hello world!
 */
public class App {
    public int add(int a, int b) {
        return a + b;
    }

    public int min(int a, int b) {
        if (a > b) return b;
        return a;
    }

    public int max(int a, int b) {
        if (min(a, b) == a) return b;
        return a;
    }
}
