package com.javatest.oop;

import java.util.*;

public class test {
    public static void runArryList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; ++i) {
            list.add(i);
        }
    }// from java 8 works faster than linkedlist

    public static void runLinkedList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1000000; ++i) {
            list.add(i);
        }
    }

    public static void seTest() {
        Set<Number> set = new TreeSet<>();
        set.add(5); //casting error, cannot compare int with long
        set.add(5L);
        set.add(5.0);
        System.out.println(set.size());

    }

    public static void foo(byte... args) {
        System.out.println("byte... args");
    }

    public static void foo(long a, short b) {
        System.out.println("long short");
    }

    public static void foo(Byte a, Byte b) {
        System.out.println("Byte Byte");
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        runArryList();
        System.out.println(System.currentTimeMillis() - time);
        System.out.println("======================================================");
//        seTest();
        System.out.println("======================================================");
        byte a = 1;
        byte b = 5;
        foo(a, b); // highest priority will have second foo
        Byte x = 1;
        Byte y = 2;
        foo(x, y);
        byte c = 3;
        foo(a, b, c);

    }
}
//Приватные методы (private) нельзя переопределять
// , так как они связываются на этапе компиляции, а не выполнения.

