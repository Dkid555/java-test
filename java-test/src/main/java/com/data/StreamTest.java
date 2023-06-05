package com.data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
//        number.add(10);
        List<Integer> g = new ArrayList<>();
        g.add(2);
        g.add(3);
        g.add(5);
        g.add(7);
        g.add(10);
        List<Integer> z = number.stream().map(x -> x * x).collect(Collectors.toList());
        List<Integer> n = g.stream().map(p -> p * p).collect(Collectors.toList());
        System.out.println(z);
        System.out.println(n);

        List<String> names = Arrays.asList("Reflfection", "Sandwich", "Collection", "Stream");

        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        List<Integer> setTest = Arrays.asList(9, 2, 3, 4, 2, 4, 5, 4, 5, 6, 7, 8);
        Set<Integer> res = setTest.stream().sorted().collect(Collectors.toSet());
        System.out.println(res);
        StringBuilder name = new StringBuilder("IsPalindrome");
        List<String> res2 = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(name.reverse());


//        System.out.println(res3);
        System.out.println(res2);
    }
}
