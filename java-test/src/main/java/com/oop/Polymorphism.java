package com.oop;

public class Polymorphism {

    public void m1() {
        System.out.println("From poly");
    }

    protected void m2() {
        System.out.println("M2");
    }

    public static void main(String[] args) {
        Polymorphism p = new Polymorphism();
        p.m1();
        Polymorphism p1 = new Polymorphism2();
        p1.m1();
        p = new Polymorphism2();
        p.m1();
        Polymorphism2 p2 = new Polymorphism2();
        p2.m1();
    }
}

class Polymorphism2 extends Polymorphism {
    public void m1() {
        System.out.println("From poly2");
    }

}
