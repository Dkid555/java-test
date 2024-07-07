package com.javatest.multithreading;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

class SingletonTest {
    public static void main(String[] args) {
        //       Singleton s = new Singleton();
        Singleton s1 = Singleton.getInstance();
//        s1 = Singleton.getInstance();
    }
}