package com.leet_easy;

public class MyHashmapGeneric<K, V> {
    private final NodeGen<K, V>[] bucket;

    public MyHashmapGeneric() {
        bucket = new NodeGen[17];
    }

    public void put(K key, V value) {
        if (bucket[(bucket.length - 1) & key.hashCode()] == null) {
            bucket[(bucket.length - 1) & key.hashCode()] = new NodeGen<K, V>(null, key, value);
        } else {
            NodeGen<K, V> root = bucket[(bucket.length - 1) & key.hashCode()];
            while (root.next != null) {
                if (root.key == key) {
                    break;
                } else root = root.next;
            }
            if (root.key == key) {
                root.value = value;
            } else {
                root.next = new NodeGen<K, V>(null, key, value);
            }

        }
    }

    public V get(K key) {
        if (bucket[(bucket.length - 1) & key.hashCode()] != null) {
            NodeGen<K, V> root = bucket[(bucket.length - 1) & key.hashCode()];
            while (root.next != null) {
                if (root.key == key) {
                    return root.value;
                }
                root = root.next;
            }
            return root.key == key ? root.value : null;
        }
        return null;
    }

    public void remove(K key) {
        if (bucket[(bucket.length - 1) & key.hashCode()] != null) {
            NodeGen<K, V> root = bucket[(bucket.length - 1) & key.hashCode()];
            if (root.key == key)
                if (root.next == null)
                    bucket[(bucket.length - 1) & key.hashCode()] = null;
                else bucket[(bucket.length - 1) & key.hashCode()] = root.next;
            else {
                NodeGen<K, V> temp = root;
                while (root.next != null) {
                    if (root.key == key) {
                        break;
                    } else {
                        temp = root;
                        root = root.next;
                    }
                }
                if (root.key == key) {
                    temp.next = temp.next.next;
                }
            }
        }
    }

    private static class NodeGen<K, V> {
        public NodeGen(NodeGen<K, V> next, K key, V value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }

        NodeGen<K, V> next;
        K key;
        V value;

    }
}


class Main3 {
    public static void main(String[] args) {
        MyHashmapGeneric<Integer, Integer> map = new MyHashmapGeneric<>();
        map.put(1, 3);
        map.put(1, 4);
        map.put(2, 4);
        map.put(13, 4);
        map.put(12, 4);
        map.remove(4);
        map.remove(12);
        map.remove(13);


        MyHashmapGeneric<String, Integer> str = new MyHashmapGeneric<>();
        str.put("anthony", 1);
        str.put("anthony", 2);
        str.put("anthOny", 3);
        str.remove("anthony");

    }

}