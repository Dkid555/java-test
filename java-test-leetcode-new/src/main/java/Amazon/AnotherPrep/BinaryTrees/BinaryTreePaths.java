package Amazon.AnotherPrep.BinaryTrees;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class BinaryTreePaths {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    private static   class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
    /**
     * Given the root of a binary tree, return all root-to-leaf paths in any order
     * A leaf is a node with no children.
     * */

    private static void dfs(TreeNode root, List<String> Paths, List<Integer> Current_path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            Current_path.add(root.val);
            Paths.add(Current_path.stream().map(String::valueOf)
                    .collect(Collectors.joining("->")));
            Current_path.remove(Current_path.size() - 1);
            return;
        }
        Current_path.add(root.val);
        dfs(root.left, Paths, Current_path);
        dfs(root.right, Paths, Current_path);
        Current_path.remove(Current_path.size() - 1);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, paths, new ArrayList<>());
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null,
                new TreeNode(5)), new TreeNode(3));

        System.out.println(binaryTreePaths(root));
    }
}
