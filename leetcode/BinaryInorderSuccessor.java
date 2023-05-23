/*In Binary Tree, Inorder successor of a node is the next node in Inorder traversal
of the Binary Tree. Inorder Successor is NULL for the last node in Inorder traversal.

In Binary Search Tree, Inorder Successor of an input node can also be defined as the node with the
smallest key greater than the key of the input node.
So, it is sometimes important to find next node in sorted order.
*
*/

package leetcode;

class TreeNod{
    int data;
    TreeNod left, right, parent;

    TreeNod(int d)
    {
        data = d;
        left = right = parent = null;
    }
}

public class BinaryInorderSuccessor {
    static TreeNode head;



    TreeNod insert(TreeNod treeNod, int data)
    {

        /* 1. If the tree is empty, return a new,
         single node */
        if (treeNod == null) {
            return (new TreeNod(data));
        }
        else {

            TreeNod temp = null;

            /* 2. Otherwise, recur down the tree */
            if (data <= treeNod.data) {
                temp = insert(treeNod.left, data);
                treeNod.left = temp;
                temp.parent = treeNod;
            }
            else {
                temp = insert(treeNod.right, data);
                treeNod.right = temp;
                temp.parent = treeNod;
            }

            /* return the (unchanged) node pointer */
            return treeNod;
        }
    }
    TreeNod inOrderSuccessor(TreeNod root, TreeNod n)
    {

        // step 1 of the above algorithm
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        TreeNod p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    /* Given a non-empty binary search
       tree, return the minimum data
       value found in that tree. Note that
       the entire tree does not need
       to be searched. */


    TreeNod minValue(TreeNod treeNod)
    {
        TreeNod current = treeNod;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }






    public static void main(String[] args)
    {
        BinaryInorderSuccessor tree = new BinaryInorderSuccessor();
        TreeNod root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        root = tree.insert(root, 15);
        root = tree.insert(root, 25);
        temp = root.left.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null) {
            System.out.println(
                    "Inorder successor of "
                            + temp.data + " is " + suc.data);
        }
        else {
            System.out.println(
                    "Inorder successor does not exist");
        }
    }

}
