package leetcode;

import java.util.HashMap;
import java.util.Enumeration;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    int size(TreeNode q, int i){
        if(q.left == null && q.right == null){
            return i+=1;
        }
        size(q.left, i);
        size(q.right, i);
        return i;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class SameTree {
    public static HashMap Check(TreeNode p, TreeNode q, HashMap dictionary){
        if ((p.left == null && p.right == null) && (q.left != null && q.right == null)){
           TreeNode z = new TreeNode();
           p.left = z;
           dictionary.put(1,1);
           return dictionary;

        } else if ((p.left == null && p.right == null) && (q.left == null && q.right != null)) {
            TreeNode z = new TreeNode();
            p.right = z;
            dictionary.put(1,1);
            return dictionary;
        } else if ((p.left == null && p.right == null) && (q.left != null && q.right != null)) {
            TreeNode z = new TreeNode();
            TreeNode z1 = new TreeNode();
            p.left = z;
            p.right = z1;
            dictionary.put(1,1);
            return dictionary;
        }
        if ((q.left == null && q.right == null) && (p.left != null && p.right == null)){
            TreeNode z = new TreeNode();
            q.left = z;
            dictionary.put(1,1);
            return dictionary;

        } else if ((q.left == null && q.right == null) && (p.left == null && p.right != null)) {
            TreeNode z = new TreeNode();
            q.right = z;
            dictionary.put(1,1);
            return dictionary;
        } else if ((q.left == null && q.right == null) && (p.left != null && p.right != null)) {
            TreeNode z = new TreeNode();
            TreeNode z1 = new TreeNode();
            q.left = z;
            q.right = z1;
            dictionary.put(1,1);
            return dictionary;
        }
        if ((p.left == null && p.right == null) && (q.left == null && q.right == null)){
            if(p.val == q.val){
                dictionary.put(0, 1);
                return dictionary;
            }
            else{
                dictionary.put(1, 1);
                return dictionary;
                }
        }

        Check(p.left,q.left,dictionary);
        Check(p.right,q.right,dictionary);
        return dictionary;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q, HashMap d) {

        if (Check(p, q, d).containsKey(1)) {
            return false;
        } else return true;
    }

    //OR less work)
    public static boolean isSameTree_1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree_1(p.left, q.left) && isSameTree_1(p.right, q.right);
    }
    public static void main(String[] args) {

        //TreeNode q3 = new TreeNode(10,null,null);
        TreeNode q2 = new TreeNode(2,null,null);
        //TreeNode q3 = new TreeNode(4,null,null);
        TreeNode q1 = new TreeNode(1,null,null);
        TreeNode q = new TreeNode(1,q1,q2);
        TreeNode p2 = new TreeNode(2,null,null);
        //TreeNode p3 = new TreeNode(1,null,null);
        TreeNode p1 = new TreeNode(1,null,null);

        TreeNode p = new TreeNode(1,p1,p2);
        System.out.println(q);
        System.out.println(p);
        HashMap d = new HashMap();

        //System.out.println(q == p);
        //System.out.println(Check(p,q,d));
        /*if (Check(p,q,d).containsKey(1)){
            System.out.println("Not the same");
        }else {System.out.println("Same");}*/
        System.out.println(isSameTree_1(p,q));
        System.out.println(isSameTree(p,q,d));


    }




}
