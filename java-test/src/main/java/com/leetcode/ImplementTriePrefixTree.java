package com.leetcode;

public class ImplementTriePrefixTree {
//    private class Trie {
//        String word;
//        Trie left;
//        Trie right;
//
//        public Trie() {
//            this.left = null;
//            this.right = null;
//            this.word = null;
//        }
//        public Trie(String word, Trie left, Trie right){
//            this.left = left;
//            this.right = right;
//            this.word = word;
//        }
//
//        public void insert(String word) {
//            if (this.word == null)
//                this.word = word;
//            else {
//                Trie newTrie = new Trie(word, null, null);
//            }
//        }
//
//        public boolean search(String word) {
//
//        }
//
//        public boolean startsWith(String prefix) {
//
//        }
//    }


    private static class Trie {
        private class Node {
            Node[] links;
            boolean flag;

            public Node() {
                this.links = new Node[26];
                this.flag = false;
            }

            boolean containsKey(char ch) {
                return (links[ch - 'a'] != null);
            }

            void put(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            Node get(char ch) {
                return links[ch - 'a'];
            }

            void setEnd() {
                flag = true;
            }

            boolean isEnd() {
                return flag;
            }
        }

        private static Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!(node.containsKey(word.charAt(i)))) {
                    node.put(word.charAt(i), new Node());
                }
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!(node.containsKey(word.charAt(i)))) {
                    return false;
                }
                node = node.get(word.charAt(i));
            }
            return node.isEnd();
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (!(node.containsKey(prefix.charAt(i)))) {
                    return false;
                }
                node = node.get(prefix.charAt(i));
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("cream");

        System.out.println(trie.search("appl"));
    }
}
