package com.Amazon.Tree;

public class ConstructQuadTree {
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    public static Node construct(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return quadTree(grid, 0, m - 1, 0, n - 1);
    }

    private static Node quadTree(int[][] grid, int startR, int endR, int startC, int endC) {
        if(startR == endR && startC == endC)
            return new Node(grid[startR][startC] == 1, true);
        int midR = (startR + endR) >> 1;
        int midC = (startC + endC) >> 1;
        Node topLeft = quadTree(grid, startR, midR, startC, midC);
        Node topRight = quadTree(grid, startR, midR, midC + 1, endC);
        Node bottomLeft = quadTree(grid, midR + 1, endR, startC, midC);
        Node bottomRight = quadTree(grid, midR + 1, endR, midC + 1, endC);
        if(topLeft.val == topRight.val
                && bottomRight.val == bottomLeft.val
                && topLeft.val == bottomLeft.val && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf)
            return new Node(topLeft.val, true);
        return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
    }


}
