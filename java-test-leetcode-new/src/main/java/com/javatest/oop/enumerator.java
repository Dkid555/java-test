package com.javatest.oop;

import java.util.*;

public class enumerator {
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<>();

        Collections.addAll(list, 1, 5, 76, 8, 524, 6, 2, 5, 7, 8, 2545, 5);

        for (Enumeration<Integer> enumeration = list.elements(); enumeration.hasMoreElements(); )
            System.out.println(enumeration.nextElement());

        //same
        System.out.println("=====================================================");
        for (Integer x : list
        ) {
            System.out.println(x);
        }
        System.out.println("=====================================================");

        Queue<Integer> queue = new PriorityQueue<>();
        Collections.addAll(queue, 1, 2, 3, 4, 5, 6);
        for (Integer x : queue) {
            System.out.println(x);
        }


    }
}
