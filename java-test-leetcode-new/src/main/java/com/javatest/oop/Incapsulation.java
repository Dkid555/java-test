package com.javatest.oop;

public class Incapsulation {
    public int a;
    protected int b;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    private int c;

    public static void main(String[] args) {
        Incapsulation i = new Incapsulation();
        i.a = 1;
        i.setC(5);
        System.out.println(i.getC());
    }
}

class Incapsulation2 extends Incapsulation {
    public void test() {
        a = 2;
        b = 3;
//        c=4;
    }
}