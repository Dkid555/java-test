package com.meta.other;

import java.util.*;

public class TopMetaCodingInterviewQuestions {

    //You are given a set of random numbers. Write a code to shift all the zeros to the left.
    public static List<Integer> shiftallthezerostotheleft(List<Integer> listOfNums) {

        int last_num_index = listOfNums.size() - 1;

        for (int i = 0; i < listOfNums.size(); ++i) {
            if (listOfNums.get(i) == 0) {
                listOfNums.remove(i--);
                --last_num_index;
                listOfNums.add(0);
            }
            if (last_num_index == i)
                break;

        }
        return listOfNums;
    }

    //Write a code to merge overlapping intervals.
    public static int[][] mergeoverlappingintervals(int[][] intervals) {
        // Проверка на случай, если входной массив пустой или содержит только один интервал
        if (intervals.length <= 1) {
            return intervals;
        }

        // Сортировка интервалов по начальным значениям, а затем по конечным значениям
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        // Инициализация текущего интервала как первого интервала в отсортированном массиве
        int[] currentInterval = intervals[0];

        // Инициализация списка для хранения объединенных интервалов
        List<int[]> merged = new ArrayList<>();

        // Обход остальных интервалов и объединение их при необходимости
        for (int i = 1; i < intervals.length; ++i) {
            int[] nextInterval = intervals[i];
            if (nextInterval[0] <= currentInterval[1]) {
                // Если следующий интервал перекрывается с текущим, расширяем текущий интервал до объединенного интервала
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // Если следующий интервал не перекрывается с текущим, добавляем текущий интервал в список объединенных интервалов
                merged.add(currentInterval);
                // Обновляем текущий интервал для следующей итерации
                currentInterval = nextInterval;
            }
        }

        // Добавление последнего объединенного интервала в список
        merged.add(currentInterval);

        // Преобразование списка в массив и возвращение его
        return merged.toArray(new int[merged.size()][]);
    }


    //You are given a binary tree. Can you in-place convert it into a doubly-linked list?

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode prev = null; // Предыдущий посещенный узел

    // Метод для преобразования бинарного дерева в двусвязный список
    public TreeNode convertToDoublyLinkedList(TreeNode root) {
        if (root == null) return null;

        // Преобразование левого поддерева в двусвязный список
        TreeNode dummy = new TreeNode(0); // Фиктивный узел для упрощения процесса
        prev = dummy;
        inOrderTraversal(root);

        // Сброс prev на самый левый узел двусвязного списка
        prev.left = null;
        TreeNode head = dummy.right; // Голова двусвязного списка

        // Преобразование двусвязного списка в круговой двусвязный список
        head.left = prev;
        prev.right = head;

        return head;
    }

    // Модифицированный метод обхода в глубину для построения двусвязного списка
    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);

        // Модификация указателей для преобразования дерева в двусвязный список
        prev.right = root;
        root.left = prev;
        prev = root;

        inOrderTraversal(root.right);
    }


    //Can you print the given binary tree's nodes level by level, i.e., print all nodes of level 1 first, then level 2, and so on?

    // Метод для вывода значений узлов бинарного дерева по уровням
    public static void print_binary_tree_by_level(TreeNode root) {
        // Проверка наличия корня дерева
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();// так как FIFO
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Количество узлов на текущем уровне
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Извлечение узла из очереди

                // Вывод значения узла
                System.out.print(node.val + " ");

                // Добавление левого и правого дочерних узлов в очередь для последующего обхода
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println(); // Переход на новую строку после вывода всех узлов на текущем уровне
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(0);
        System.out.println(shiftallthezerostotheleft(list));

        System.out.println(Arrays.deepToString(mergeoverlappingintervals(new int[][]{{1, 3}, {1, 1}, {1, 2}, {2, 4}})));

        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(5), new TreeNode(6)));
        print_binary_tree_by_level(root);
    }
}
