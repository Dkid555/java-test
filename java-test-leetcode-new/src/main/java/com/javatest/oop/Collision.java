package com.javatest.oop;

import com.javatest.leetcode.Node;

import java.util.HashMap;
import java.util.Map;

public class Collision {
//    public static void main(String[] args) {
//
//        System.out.println("Aa".hashCode() + "," + "BB".hashCode());
//        System.out.println("Da".hashCode() + "," + "EB".hashCode());
//        Map<String, Integer> map = new HashMap<>();
//
//
//    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(16);
        Node[] arr = new Node[17];
        Integer a = 15;
        Integer b = 12;

        arr[16 & a.hashCode()] = new Node(a);
        arr[16 & b.hashCode()].Add(b);


        System.out.println(b.hashCode());

    }
}
