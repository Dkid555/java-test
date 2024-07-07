package Amazon.AnotherPrep.BinaryTrees;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

public class MinimumDepthofBinaryTree {

    @Generated
    @Getter
    @Setter
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private void dfs(TreeNode treenode, int[] min, int current_path){
        if(treenode == null)
            return;
        if(treenode.left == null && treenode.right == null){
            min[0] = Math.min(min[0], current_path + 1);
        }
        dfs(treenode.left, min, current_path + 1);
        dfs(treenode.right, min, current_path + 1);
    }
    public int minDepth(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        if(root == null)
            return 0;
        dfs(root, min, 0);
        return min[0];
    }
    public static void main(String[] args) {
//        int[] min = {Integer.MAX_VALUE};
//        Tree
//        dfs(tree)
    }
}
