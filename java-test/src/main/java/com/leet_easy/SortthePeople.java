package com.leet_easy;

import java.util.*;

public class SortthePeople {

    // Priority Queue + class People + Comparator
    private static class People {
        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }

        String name;
        int height;
    }

    // Можно и без этого, сделать лямбдой.
    static class PeopleComparatorHeights implements Comparator<People> {
        @Override
        public int compare(People o1, People o2) {
            if (o1.height < o2.height)
                return 1;
            else if (o1.height > o2.height)
                return -1;
            return 0;
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
//        PriorityQueue<People> people = new PriorityQueue<>(names.length,new PeopleComparatorHeights());

        PriorityQueue<People> people = new PriorityQueue<>((p1, p2) -> {
            return p2.height - p1.height;
        });
        for (int i = 0; i < names.length; i++) {
            people.add(new People(names[i], heights[i]));
        }
        int i = 0;
        while (!people.isEmpty()) {
            names[i++] = people.poll().name;
        }
        return names;
    }

    public static String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> people = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            people.put(heights[i], names[i]);
        }
        int i = names.length;
        for (String name : people.values()) {
            names[--i] = name;
        }
        return names;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortPeople2(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})));
    }
}
