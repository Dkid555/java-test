package com.javatest.meta.other;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return ("TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}');
    }
}

public class VerticalOrderTraversalOfBT {
    public static void columnByColumn(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root.left == null && root.right == null) {
            List<Integer> temp = map.getOrDefault(level, new ArrayList<>());
            temp.add(root.val);
            map.put(level, temp);
            return;
        }
        if (root.right != null)
            columnByColumn(root.right, map, level + 1);
        if (root.left != null)
            columnByColumn(root.left, map, level - 1);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(5, new TreeNode(2), new TreeNode(6)),
                new TreeNode(3, new TreeNode(7), new TreeNode(4)));
        TreeNode treeNode2 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

//        Map<Integer, List<Integer>> map = new HashMap<>();
//        columnByColumn(treeNode2, map, 0);
//
//        List<Integer> temp = map.getOrDefault(0, new ArrayList<>());
//        temp.add(treeNode.val);
//        map.put(0, temp);
//
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
//
//            System.out.println(entry.getKey() + ' ' + entry.getValue().toString());
//        }

        System.out.println(verticalTraversal(treeNode2));
    }


    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>>[] map_of_lists = new Map[1001];

        Stack<Integer> max = new Stack<>();
        max.push(Integer.MIN_VALUE);

        columnByColumnDive(root, map_of_lists, 0, 0, max);

        List<List<Integer>> result = new ArrayList<>();

        if (!max.isEmpty()) {
            int max_size = max.pop();
            for (int i = 0; i <= max_size; ++i) {
                Map<Integer, List<Integer>> listFromMap = map_of_lists[i];
                if (listFromMap != null) {

                    List<Integer> temp = new ArrayList<>();
                    List<Integer> rows = new ArrayList<>(listFromMap.keySet().stream().toList());
                    Collections.sort(rows);

                    for (int row : rows) {
                        Collections.sort(listFromMap.get(row));
                        temp.addAll(listFromMap.get(row));
                    }
                    result.add(temp);
                }

            }
        }

        return result;
    }

    public static void columnByColumnDive(TreeNode root, Map<Integer, List<Integer>>[] map_of_lists, int column,
                                          int row, Stack<Integer> max) {
        if (root == null)
            return;
        if (root.left != null)
            columnByColumnDive(root.left, map_of_lists, column - 1, row + 1, max);
        if (root.right != null)
            columnByColumnDive(root.right, map_of_lists, column + 1, row + 1, max);


        if (map_of_lists[column + 500] == null) {
            map_of_lists[column + 500] = new HashMap<>();
        }
        List<Integer> temp = map_of_lists[column + 500].getOrDefault(row, new ArrayList<>());
        temp.add(root.val);
        map_of_lists[column + 500].put(row, temp);

        max.push(Math.max(max.pop(), column + 500));

    }

}
