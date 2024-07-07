package com.javatest.oop;

public class Inheritance {
    public int a;
    private int b;

    public void m1() {
        System.out.println("m1");
    }

    public static void main(String[] args) {
        Inheritance i = new Inheritance2();
        i.m1();
    }
}

class Inheritance2 extends Inheritance {

}








