package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeinBinarySearchTree {

    private class MostFreaq {
        List<Integer> result;
        int freq;
        Map<Integer, Integer> frequency;

        public MostFreaq(List<Integer> result, int freq, Map<Integer, Integer> frequency) {
            this.result = result;
            this.freq = freq;
            this.frequency = frequency;
        }
    }

    public int[] findMode(TreeNode root) {
        MostFreaq freaq = new MostFreaq(new ArrayList<>(), 0, new HashMap<>());
        search(root, freaq);
        return freaq.result.stream().mapToInt(i -> i).toArray();
    }

    private void search(TreeNode root, MostFreaq freaq) {
        if (root == null)
            return;
        freaq.frequency.put(root.val, freaq.frequency.getOrDefault(root.val, 0) + 1);
        int fre = freaq.frequency.get(root.val);
        if (fre >= freaq.freq) {
            if (fre == freaq.freq)
                freaq.result.add(root.val);
            else {
                freaq.result = new ArrayList<>();
                freaq.result.add(root.val);
                freaq.freq = fre;
            }

        }
        search(root.left, freaq);
        search(root.right, freaq);
    }
}
//Given the root of a binary search tree (BST) with duplicates,
// return all the mode(s) (i.e., the most frequently occurred element) in it.

//If the tree has more than one mode, return them in any order.
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.