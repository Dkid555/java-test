package com.leet_easy;

import java.util.*;

public class LRUCache {

//    Map<Integer, Integer> search;
//    List<>
    private final Deque<Integer> deque;
    private final HashMap<Integer,Integer> hashMap;
    private final int CACHE_SIZE;
    public LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        deque = new LinkedList<>();
        hashMap = new HashMap<>();

    }

    public void put(int key, int value){
        if(!hashMap.containsKey(key)){
            if (deque.size() == CACHE_SIZE){
                int last = deque.removeLast();
                hashMap.remove(last);
            }
        }
        else {
            deque.remove(key);
        }
        deque.push(key);
        hashMap.put(key, value);
    }

    public int get(int key) {
        if(!hashMap.containsKey(key))
            return -1;
        else {
            new Thread(()->{
                deque.remove(key);
                deque.push(key);
            }).start();
            return hashMap.get(key);

        }
    }

}
class DoubleLinkedNode<K, V>{
    public DoubleLinkedNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public K key;
    public V value;
    public DoubleLinkedNode<Integer, Integer> prev;
    public DoubleLinkedNode<Integer, Integer> next;
}
class LRUCache2{

    Map<Integer, DoubleLinkedNode<Integer, Integer>> map;
    private DoubleLinkedNode<Integer,Integer> head;
    private DoubleLinkedNode<Integer,Integer> tail;
    private int SIZE;
    public LRUCache2(int capacity){
        SIZE = capacity;
        map = new HashMap<>();
        head = new DoubleLinkedNode<>(-1,-1);
        tail = new DoubleLinkedNode<>(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void DeleteNode(DoubleLinkedNode<Integer, Integer> del){
        DoubleLinkedNode<Integer, Integer> prev = del.prev;
        DoubleLinkedNode<Integer, Integer> next = del.next;
        prev.next = next;
        next.prev = prev;
    }
    private void add(DoubleLinkedNode<Integer, Integer> newN){
        DoubleLinkedNode<Integer, Integer> temp = head.next;
        head.next = newN;
        newN.prev = head;
        newN.next = temp;
        temp.prev = newN;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            DoubleLinkedNode<Integer, Integer> temp = map.get(key);
            DeleteNode(temp);
            temp.value = value;
            add(temp);
            map.put(key, head.next); // head.next - our temp
        }else {
            if(map.size() > SIZE){
                DoubleLinkedNode<Integer, Integer> prev = tail.prev;
                DeleteNode(prev);
                DoubleLinkedNode<Integer, Integer> temp = new DoubleLinkedNode<>(key,value);
                add(temp);
                map.remove(prev.key);
                map.put(key, head.next);
            }else {
                DoubleLinkedNode<Integer,Integer> temp = new DoubleLinkedNode<>(key,value);
                add(temp);
                map.put(key, head.next);
            }
        }
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        DoubleLinkedNode<Integer, Integer> temp = map.get(key);
        DeleteNode(temp);
        add(temp);
        map.put(key, temp);// перезаписываем чтобы обновились пути next и prev;
        return head.next.value;
    }
}



class SL{
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        String[] as = {"put","put","get","put","get","put","get","get","get"};
        int[][] ass = {{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4}};

        for (int i = 0; i< as.length ;i++){
            switch (as[i]){
                case "put" -> cache.put(ass[i][0], ass[i][1]);
                case "get" -> System.out.println("get "+ ass[i][0] + ": "  + cache.get(ass[i][0]));
            }
        }
//        cache.put(1 , 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
    }
}




// this works
class LRUCache3{
    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    private Map<Integer, Node> m;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache3(int capacity) {
        size = capacity;
        m = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node p) {
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next = temp;
        temp.prev = newnode;
    }

    public int get(int key) {
        if (!m.containsKey(key))
            return -1;

        Node p = m.get(key);
        deleteNode(p);
        addNode(p);
        m.put(key, head.next);
        return head.next.val;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node c = m.get(key);
            deleteNode(c);
            c.val = value;
            addNode(c);
            m.put(key, head.next);
        } else {
            if (m.size() == size) {
                Node prev = tail.prev;
                deleteNode(prev);
                Node l = new Node(key, value);
                addNode(l);
                m.remove(prev.key);
                m.put(key, head.next);
            } else {
                Node l = new Node(key, value);
                addNode(l);
                m.put(key, head.next);
            }
        }
    }
}
