package com.leetcode;

import java.util.Iterator;
import java.util.List;

public class PeekingIterator {
    DoubleLinkedList linkedList;

    private static class DoubleLinkedList {
        int value;
        DoubleLinkedList next;
        DoubleLinkedList previous;

        public DoubleLinkedList(int value, DoubleLinkedList next, DoubleLinkedList previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    public PeekingIterator(Iterator<Integer> iterator) {
        if (iterator.hasNext())
            linkedList = new DoubleLinkedList(12, null, null);
        DoubleLinkedList temp = this.linkedList;
        while (iterator.hasNext()) {
            temp.next = new DoubleLinkedList(iterator.next(), null, temp);
            temp = temp.next;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (this.hasNext())
            return this.linkedList.next.value;
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        if (this.hasNext()) {
            this.linkedList = this.linkedList.next;
            return this.linkedList.value;
        }
        return null;
    }

    public boolean hasNext() {
        return this.linkedList.next != null;
    }
}

class Mia {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);


        Iterator<Integer> iterator = list.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        while (peekingIterator.hasNext()) {
            System.out.println(peekingIterator.next());
        }

    }
}

class PeekingIterator2 implements Iterator<Integer> {
    private Iterator<Integer> iterator = null;
    private Integer next = null;

    public PeekingIterator2(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) { // сразу смещаемся в следующий элемент
            this.next = this.iterator.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer returnValue = next;
        if (iterator.hasNext()) {
            this.next = iterator.next();
        } else {
            this.next = null;
        }
        return returnValue;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }
}