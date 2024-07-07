package com.javatest.oop;

import java.util.*;
import java.util.function.Consumer;

public class iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};
        Collections.addAll(list, arr);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=======================================================");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======================================================");
        List<Integer> linkedlist = new LinkedList<>();
        Collections.addAll(linkedlist, arr);
        Iterator<Integer> iterator1 = linkedlist.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("=======================================================");
        for (Integer x : linkedlist
        ) {
            System.out.println(++x);
        }
        System.out.println("=======================================================");

        Iterator<Integer> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            int i = iterator2.next();
            if (i > 2) iterator2.remove();
        }
        for (int x : list
        ) {
            System.out.println(x);
        }

        System.out.println("=============================");

        Collections.addAll(list, new Integer[]{3, 4, 5, 6});
        Iterator<Integer> iterator3 = linkedlist.iterator();
        Iterator<Integer> iterator4 = list.iterator();

        while (iterator3.hasNext() && iterator4.hasNext()) {
            iterator3.next();
            iterator4.next();
            System.out.println(iterator3.equals(iterator4));
        }
        // will be false


    }
}

class listiter {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, new Integer[]{1, 2, 3, 4, 5, 6});
        ListIterator<Integer> listIterator = list.listIterator();
//        list.removeIf(Integer x : list: x > 2)
//        listIterator
//        adds to the first position
        listIterator.add(7);
        for (Integer x :
                list) {
            System.out.println(x);
        }
        System.out.println("======================================================");
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        listIterator.add(11);
//        adds to the last
        for (Integer x :
                list) {
            System.out.println(x);
        }
        System.out.println("=======================================================");
//        removeif

        list.removeIf(item -> item > 7); // lambda
        for (Integer x :
                list) {
            System.out.println(x);
        }
    }
}


////////////////////////////////////////////////////////////

class iterable {
    public static void main(String[] args) {

        for (int i : Range.fromTo(0, 100)) {
            System.out.println(i);
        }

    }

    private static class Range implements Iterable<Integer> {

        int start;
        int end;

        public static Range fromTo(int from, int to) {
            return new Range(from, to);
        }

        private Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Iterator iterator() {
            return new Iterator(start);
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            Iterable.super.forEach(action);
        }

        @Override
        public Spliterator<Integer> spliterator() {
            return Iterable.super.spliterator();
        }

        class Iterator implements java.util.Iterator<Integer> {
            int current;

            public Iterator(int current) {
                this.current = current;
            }

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                return current++;
            }
        }
    }
}
