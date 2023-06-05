package com.data;

import java.util.*;

public class ListTest {


    public static void main(String[] args) {
        List list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        System.out.println("===========================================================");

        List<Integer> list3 = new LinkedList();

        list3.add(0);
        list3.add(3);
        list3.add(7);


        System.out.println(list3.stream().filter(l -> l > 0).toList());

        System.out.println("===========================================================");
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
//        List square = number.stream().map(x -> x+x).collect(Collectors.toList());
        String s = "asdf";
        String a = s;
        Set<Integer> set = new LinkedHashSet<>();
    }

}
