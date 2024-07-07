package com.Amazon;

//import javax.swing.tree.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueinEachTreeRow {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max_Number = new ArrayList<>();
        traverse(root, max_Number, 0);
        return max_Number;
    }

    private void traverse(TreeNode root, List<Integer> max_Number, int level){
        if(root == null)
            return;

        if(max_Number.size() == level)
            max_Number.add(root.val);
        else{
            max_Number.set(level, Math.max(root.val, max_Number.get(level)));
        }
        traverse(root.left, max_Number, level + 1);
        traverse(root.right, max_Number, level + 1);
    }
}
