package com.leetcode;

import java.util.Stack;

public class BinarySearchTreeIterator {
    static class BSTIterator {
        TreeNode temp;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.temp = root;
            this.stack = new Stack<>();
        }

        public int next() {
            int result = 0;
            while (true) {
                if (this.temp != null) {
                    stack.push(this.temp);
                    this.temp = this.temp.left;
                } else if (stack.isEmpty())
                    break;
                else {
                    this.temp = this.stack.pop();
                    if (this.temp != null) result = this.temp.val;
                    this.temp = this.temp != null ? this.temp.right : null;
                    break;
                }
            }
            return result;
        }


        public boolean hasNext() {
            return this.temp != null || !this.stack.isEmpty();
        }
    }


    class BSTIterator2 {
        private TreeNode tree = null;

        public BSTIterator2(TreeNode root) {
            tree = root;
        }

        public int next() {
            TreeNode parent = null;
            TreeNode left = tree;
            while (left.left != null) {
                parent = left;
                left = left.left;
            }
            int val = left.val;
            if (parent != null) {
                parent.left = left.right;
            } else {
                tree = left.right;
            }
            return val;
        }

        public boolean hasNext() {
            return tree != null;
        }
    }

}
