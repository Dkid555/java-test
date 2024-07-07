package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignLinkedList {
    int size;
    ListNode head;

    public DesignLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode sentinel = this.head;
        for (int i = 0; i < index + 1; ++i) sentinel = sentinel.next;
        return sentinel.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size) return;
        if (index < 0) index = 0;
        ++size;
        ListNode sentinel = this.head;
        for (int i = 0; i < index; ++i) sentinel = sentinel.next;
        ListNode node = new ListNode(val);
        node.next = sentinel.next;
        sentinel.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) return;
        size--;
        ListNode sentinel = this.head;
        for (int i = 0; i < index; ++i) sentinel = sentinel.next;
        sentinel.next = sentinel.next.next;
    }
}

class MyLinkedList {
    List<Integer> list;

    public MyLinkedList() {
        list = new ArrayList<>();
    }

    public int get(int index) {
        if (index < list.size()) {
            return list.get(index);
        }
        return -1;
    }

    public void addAtHead(int val) {
        list.add(0, val);
    }

    public void addAtTail(int val) {
        list.add(val);
    }

    public void addAtIndex(int index, int val) {
        if (index <= list.size()) {
            list.add(index, val);
        }
    }

    public void deleteAtIndex(int index) {
        if (list.size() > index) {
            list.remove(index);
        }
    }
}
