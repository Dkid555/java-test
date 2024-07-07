package com.javatest.leet_easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Compare implements Comparable, Iterable {

    ArrayList<String> value;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Iterator iterator() {

        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}


class main {
    public static void main(String[] args) {

    }
}
