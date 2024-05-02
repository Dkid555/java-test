package com.Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // если высота одинаковая то сортируем по размеру очереди по возрастанию
        // если она разная то по высоте по убыванию
        List<int[]> ordered = new LinkedList<>();
        for(int[] human : people)
            ordered.add(human[1], human);
        return ordered.toArray(new int[people.length][]);

    }
}
//You are given an array of people, people, which are
// the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki]
// represents the ith person of height hi with exactly ki other
// people in front who have a height greater than or equal to hi.
//
//Reconstruct and return the queue that is represented by the input
// array people. The returned queue should be formatted as an array
// queue, where queue[j] = [hj, kj] is the attributes of the jth person
// in the queue (queue[0] is the person at the front of the queue).