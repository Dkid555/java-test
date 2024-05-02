package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class DesignCircularQueue {
    static class MyCircularQueue {
        List<Integer> list;
        int max;

        public MyCircularQueue(int k) {
            list = new ArrayList<>();
            max = k;
        }

        public boolean enQueue(int value) {
            if (list.size() == max) return false;
            list.add(value);
            return true;
        }

        public boolean deQueue() {
            if (list.isEmpty()) return false;
            list.remove(0);
            return true;
        }

        public int Front() {
            if (list.isEmpty()) return -1;
            return list.get(0);
        }

        public int Rear() {
            if (list.isEmpty()) return -1;
            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public boolean isFull() {
            return list.size() == max;
        }
    }
}
// Design your implementation of the circular queue. The circular
// queue is a linear data structure in which the operations are
// performed based on FIFO (First In First Out) principle, and the
// last position is connected back to the first position to make
// a circle. It is also called "Ring Buffer".
//
//One of the benefits of the circular queue is that we can make use of the
// spaces in front of the queue. In a normal queue, once the queue becomes
// full, we cannot insert the next element even if there is a space in front
// of the queue. But using the circular queue, we can use the space to store new values.
//
//Implement the MyCircularQueue class:
//
//MyCircularQueue(k) Initializes the object with the size of the queue to be k.
//int Front() Gets the front item from the queue. If the queue is empty, return -1.
//int Rear() Gets the last item from the queue. If the queue is empty, return -1.
//boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
//boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
//boolean isEmpty() Checks whether the circular queue is empty or not.
//boolean isFull() Checks whether the circular queue is full or not.