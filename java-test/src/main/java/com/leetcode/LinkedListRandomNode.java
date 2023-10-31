package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    List<ListNode> rand;

    public LinkedListRandomNode(ListNode head) {
        this.rand = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            this.rand.add(temp);
            temp = temp.next;
        }
    }

    public int getRandom() {
        int random = new Random().nextInt(this.rand.size());
        return this.rand.get(random).val;
    }
}
//Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
//
//Implement the Solution class:
//
//Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
//int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.