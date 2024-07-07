package com.javatest.oop;

public class Generics {
    public static void main(String[] args) {
        IntegerPrinter printer = new IntegerPrinter(12);
        printer.print();


        Printer<Double> printer1 = new Printer<>(13.04);
        printer1.print();


        Byte b = -128;

        System.out.println(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
    }
}

//to change type we will have to rewrite whole class
class IntegerPrinter {
    Integer thingtoprint;

    public IntegerPrinter(Integer thingtoprint) {
        this.thingtoprint = thingtoprint;
    }

    public void print() {
        System.out.println(thingtoprint);
    }
}

//and with generics

class Printer<T> { // in java it basically called t, but we can call it whatever we want

    T thingtoprint;

    public Printer(T thingtoprint) {
        this.thingtoprint = thingtoprint;
    }

    public void print() {
        System.out.println(thingtoprint);
    }


}

