package com.leet_easy;

public class MyHashSetGeneric<T> {
    NodeSetGen<T>[] bucket;

    public MyHashSetGeneric() {
        bucket = new NodeSetGen[16];
    }

    public void add(T key) {
        if (bucket[(bucket.length - 1) & key.hashCode()] == null) {
            bucket[(bucket.length - 1) & key.hashCode()] = new NodeSetGen<T>(null, key);
        } else {
            NodeSetGen<T> root = bucket[(bucket.length - 1) & key.hashCode()];
            while (root.next != null) {
                if (root.key == key) {
                    break;
                }
                root = root.next;
            }
            if (root.key != key) {
                root.next = new NodeSetGen<T>(null, key);
            }
//            root.next = (root.key != key) ? new NodeSet(null, key) : null;
        }
    }

    public void remove(T key) {
        if (bucket[(bucket.length - 1) & key.hashCode()] != null) {
            NodeSetGen<T> root = bucket[(bucket.length - 1) & key.hashCode()];
            if (root == null) return;
            if (root.key == key) {
                bucket[(bucket.length - 1) & key.hashCode()] = root.next;
            } else {
                NodeSetGen<T> temp = root;
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

    public boolean contains(T key) {
        if (bucket[(bucket.length - 1) & key.hashCode()] != null) {
            NodeSetGen<T> root = bucket[(bucket.length - 1) & key.hashCode()];
            while (root.next != null) {
                if (root.key == key)
                    return true;
                root = root.next;
            }
            return root.key == key;
        }
        return false;
    }
}

class NodeSetGen<T> {
    public NodeSetGen(NodeSetGen<T> next, T key) {
        this.next = next;
        this.key = key;
    }

    NodeSetGen<T> next;
    T key;

}

class Main6 {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        String[] deal = {"MyHashSet", "remove", "remove", "add", "add", "contains", "add", "add", "add", "remove", "contains", "add", "add", "add", "remove", "add", "remove", "add", "add", "add", "remove", "add", "remove", "contains", "add", "add", "add", "add", "add", "add", "add", "remove", "remove", "remove", "add", "add", "remove", "add", "contains", "contains", "add", "remove", "add", "add", "add", "add", "add", "contains", "contains", "add", "add", "add", "add", "add", "remove", "contains", "remove", "add", "add", "add", "add", "add", "remove", "add", "add", "add", "add", "contains", "add", "add", "add", "add", "add", "remove", "add", "add", "contains", "add", "add", "add", "remove", "remove", "remove", "remove", "contains", "contains", "add", "add", "contains", "add", "add", "add", "add", "add", "contains", "contains", "add", "remove", "add", "remove", "add"};
        int[] val = {-1, 88, 56, 17, 20, 83, 43, 27, 20, 21, 15, 90, 69, 95, 12, 60, 78, 94, 85, 70, 45, 84, 89, 17, 12, 47, 26, 90, 26, 63, 88, 83, 51, 10, 71, 85, 38, 1, 87, 27, 26, 30, 44, 39, 89, 54, 18, 84, 94, 63, 41, 77, 31, 9, 76, 85, 80, 6, 85, 13, 89, 49, 12, 35, 81, 32, 75, 48, 33, 33, 0, 6, 97, 3, 94, 90, 9, 87, 68, 32, 3, 85, 13, 89, 18, 78, 57, 47, 85, 94, 53, 14, 12, 62, 44, 31, 10, 69, 48, 38, 54};
        for (int i = 1; i < deal.length; i++) {
            if (val[i] == 31) System.out.println("point " + i);
            if (i == 52) {
                System.out.println("bas");
            }
            switch (deal[i]) {
                case "remove" -> set.remove(val[i]);
                case "add" -> set.add(val[i]);
                case "contains" -> System.out.println(val[i] + ": " + set.contains(val[i]));

            }
        }
        //        set.add(1);
//        set.add(2);
//        set.add(4);
//        set.add(44);
//        set.add(31);
//        set.add(22);
//        set.remove(4);
//        System.out.println(set.contains(31));
    }
}


///class Node{
//    Node next;
//    int val;
//    public Node(int key){
//        this.val=key;
//        this.next=null;
//    }
//}
//class MyHashSet {
//    Node head;
//    public MyHashSet() {
//       head=null;
//    }
//
//    public void add(int key) {
//        if(head==null)
//        {
//            head= new Node(key);
//            return;
//        }
//        boolean doesExists=contains(key);
//        if(!doesExists){
//            Node temp=head;
//            while(temp.next!=null)
//                temp=temp.next;
//
//            temp.next=new Node(key);
//        }
//    }
//
//    public void remove(int key) {
//        if(head==null) return;
//        if(head.val==key){
//            head=head.next;
//            return;
//        }
//
//        Node temp=head;
//        while(temp.next!=null){
//            if(temp.next.val==key)
//                temp.next=temp.next.next;
//            else
//                temp=temp.next;
//        }
//    }
//
//    public boolean contains(int key) {
//        if(head==null) return false;
//        if(head.val==key) return true;
//
//        Node temp=head;
//        while(temp.next!=null){
//            if(temp.next.val==key) return true;
//            temp=temp.next;
//        }
//        return false;
//    }
//}