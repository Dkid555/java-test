package com.javatest.leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private int i = 0; // Индекс для массива inorder
    private int p = 0; // Индекс для массива preorder

    // Метод для построения дерева по предварительному и внутреннему обходам
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    // Рекурсивный метод для построения дерева
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        // Если индекс preorder превысил его длину, значит, мы достигли конца поддерева
        if (p >= preorder.length) {
            return null;
        }
        // Если значение в массиве inorder равно stop, это означает, что текущий узел - лист
        if (inorder[i] == stop) {
            ++i; // Увеличиваем индекс inorder
            return null;
        }

        // Создаем новый узел с текущим значением preorder[p]
        TreeNode node = new TreeNode(preorder[p++]);

        // Рекурсивно строим левое поддерево, передавая текущее значение в качестве stop
        node.left = build(preorder, inorder, node.val);

        // Рекурсивно строим правое поддерево, передавая stop такое же, как и для родительского узла
        node.right = build(preorder, inorder, stop);

        // Возвращаем созданный узел
        return node;
    }
}
