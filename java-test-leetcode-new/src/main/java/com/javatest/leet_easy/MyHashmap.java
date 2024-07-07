package com.javatest.leet_easy;

public class MyHashmap {
    Node[] bucket;

    public MyHashmap() {
        bucket = new Node[17];
    }

    public void put(int key, int value) {
        if (bucket[(bucket.length - 1) & key] == null) {
            bucket[(bucket.length - 1) & key] = new Node(null, key, value);
        } else {
            Node root = bucket[(bucket.length - 1) & key];
            while (root.next != null) {
                if (root.key == key) {
                    break;
                } else root = root.next;
            }
            if (root.key == key) {
                root.value = value;
            } else {
                root.next = new Node(null, key, value);
            }

        }
    }

    public int get(int key) {
        if (bucket[(bucket.length - 1) & key] != null) {
            Node root = bucket[(bucket.length - 1) & key];
            while (root.next != null) {
                if (root.key == key) {
                    return root.value;
                }
                root = root.next;
            }
            return root.key == key ? root.value : -1;
        }
        return -1;
    }

    public void remove(int key) {
        if (bucket[(bucket.length - 1) & key] != null) {
            Node root = bucket[(bucket.length - 1) & key];
            if (root.key == key)
                if (root.next == null)
                    bucket[(bucket.length - 1) & key] = null;
                else bucket[(bucket.length - 1) & key] = root.next;
            else {
                Node temp = root;
                while (temp.next != null) {
                    if (temp.next.key == key)
                        temp.next = temp.next.next;
                    else
                        temp = temp.next;
                }
//                while (root.next != null){
//                    if(root.key == key){
//                        break;
//                    }
//                    else {
//                        temp = root;
//                        root = root.next;
//                    }
//                }
//                if(root.key == key){
//                    temp.next = temp.next.next;
//                }
            }
        }
    }
}

class Node {
    public Node(Node next, int key, int value) {
        this.next = next;
        this.key = key;
        this.value = value;
    }

    Node next;
    int key;
    int value;

}

class Main5 {
    public static void main(String[] args) {
        MyHashmap map = new MyHashmap();
        map.put(1, 3);
        map.put(1, 4);
        map.put(2, 4);
        map.put(13, 4);
        map.put(12, 4);
        map.remove(4);
        map.remove(12);
        map.remove(13);
    }

}