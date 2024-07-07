package com.javatest.leetcode;

import java.util.*;

public class AverageofLevelsinBinaryTree {

    private static class NumberOfEntries {
        int entries;
        Stack<Double> stack;

        public NumberOfEntries(int entries, Stack<Double> stack) {
            this.entries = entries;
            this.stack = stack;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, NumberOfEntries> map = new HashMap<>();
        List<Double> result = new ArrayList<>();
        diveInto(root, 0, map);
        for (Map.Entry<Integer, NumberOfEntries> entry : map.entrySet())
            result.add(entry.getValue().stack.pop());
        return result;
    }

    public static void diveInto(TreeNode root, int count, Map<Integer, NumberOfEntries> map) {
        if (root == null)
            return;
        if (map.containsKey(count)) {
            double previous = map.get(count).stack.pop() * map.get(count).entries;
            ++map.get(count).entries;
            map.get(count).stack.push((previous + (double) root.val) / map.get(count).entries);
        } else {
            Stack<Double> stack = new Stack<>();
            stack.push((double) root.val);
            map.put(count, new NumberOfEntries(1, stack));
        }
        diveInto(root.left, ++count, map);
        --count;
        diveInto(root.right, ++count, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        System.out.println(averageOfLevels(root));
    }
}
//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
//