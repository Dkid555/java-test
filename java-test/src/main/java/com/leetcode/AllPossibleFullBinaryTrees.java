package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> all = new ArrayList<>();
        if (this.map.containsKey(n))
            return this.map.get(n);
        if (n == 1) {
            TreeNode temp = new TreeNode(0);
            all.add(temp);
            this.map.put(n, all);
        } else if (n == 3) {
            TreeNode temp = new TreeNode(0, new TreeNode(0), new TreeNode(0));
            all.add(temp);
            this.map.put(n, all);
        } else {
            for (int i = 1; i < n; ++i) {
                int rightNodes = n - i - 1;
                List<TreeNode> Left = allPossibleFBT(i);
                List<TreeNode> Right = allPossibleFBT(rightNodes);
                for (TreeNode left : Left)
                    for (TreeNode right : Right) {
                        TreeNode root = new TreeNode(0, left, right);
                        all.add(root);
                    }
            }
            this.map.put(n, all);
        }

        return this.map.get(n);
    }
}

class Main {
    public static void main(String[] args) {
        AllPossibleFullBinaryTrees all = new AllPossibleFullBinaryTrees();
        System.out.println(all.allPossibleFBT(5));
    }
}
//Map<Integer, List<TreeNode>> map = new HashMap<>();
//    public List<TreeNode> allPossibleFBT(int n) {
//        List<TreeNode> al = new ArrayList<>();
//        if(map.containsKey(n)) {
//            return map.get(n);
//        }
//        if(n == 1) {
//            al.add(new TreeNode(0));
//            map.put(n, al);
//        } else if(n == 3) {
//            TreeNode root = new TreeNode(0, new TreeNode(0), new TreeNode(0));
//            al.add(root);
//            map.put(n, al);
//        } else {
//            for(int i = 1; i < n; i++) {
//                int rightNodes = n - 1 - i;
//                List<TreeNode> left = allPossibleFBT(i);
//                List<TreeNode> right = allPossibleFBT(rightNodes);
//                for(TreeNode l : left) {
//                    for(TreeNode r : right) {
//                        TreeNode root = new TreeNode(0, l, r);
//                        al.add(root);
//                    }
//                }
//            }
//            map.put(n, al);
//        }
//        return map.get(n);
//    }