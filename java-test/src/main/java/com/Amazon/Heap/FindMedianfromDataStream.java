package com.Amazon.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    private static class MedianFinder {
        private final PriorityQueue<Integer> minHeap;
        private final PriorityQueue<Integer> maxHeap;
        private boolean even;

        public MedianFinder() {
            this.even = true;
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        }

        public void addNum(final int num) {
            if(even) {
                this.minHeap.offer(num);
                this.maxHeap.offer(this.minHeap.poll());
            } else {
                this.maxHeap.offer(num);
                this.minHeap.offer(this.maxHeap.poll());
            }

            even = !even;
        }

        public double findMedian() {
            return even ? (this.minHeap.peek() + this.maxHeap.peek()) / 2.0 : this.maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
