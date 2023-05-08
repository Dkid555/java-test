package leetcode;


public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root7 = new TreeNode(3, null, null);
        TreeNode root6 = new TreeNode(4, null, null);
        TreeNode root5 = new TreeNode(4, null, null);
        TreeNode root4 = new TreeNode(3, null, null);
        TreeNode root3 = new TreeNode(2, root6, root7);
        TreeNode root2 = new TreeNode(2, root4, root5);

        TreeNode root = new TreeNode(1,root2,root3);

        TreeNode q = root;

        System.out.println(root);
        System.out.println(check(root,q));



    }

   public static boolean check(TreeNode root,TreeNode q) {

        if ((root == null && q != null) || (root != null && q == null)){
            return false;}
        if (root == null && q == null) {
            return true;

        } else if (root.val != q.val){
            return false;
        }
        return check(root.left, q.right) && check(root.right, q.left);

    }
}
