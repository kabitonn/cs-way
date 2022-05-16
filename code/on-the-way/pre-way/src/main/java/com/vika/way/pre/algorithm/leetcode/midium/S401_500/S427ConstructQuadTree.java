package com.vika.way.pre.algorithm.leetcode.midium.S401_500;



public class S427ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public static void main(String[] args) {
        S427ConstructQuadTree solution = new S427ConstructQuadTree();
        int[][] grid = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        System.out.println(solution.construct(grid));
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, 0, n - 1, n - 1);
    }

    public Node construct(int[][] grid, int i1, int j1, int i2, int j2) {
        int base = grid[i1][j1];
        boolean flag = true;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (grid[i][j] != base) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            return new Node(base == 1, true, null, null, null, null);
        }
        Node node = new Node();
        node.isLeaf = false;
        int n = (i2 - i1 + 1) / 2;
        node.topLeft = construct(grid, i1, j1, i1 + n - 1, j1 + n - 1);
        node.topRight = construct(grid, i1, j1 + n, i1 + n - 1, j2);
        node.bottomLeft = construct(grid, i1 + n, j1, i2, j1 + n - 1);
        node.bottomRight = construct(grid, i1 + n, j1 + n, i2, j2);
        return node;
    }

    public Node construct1(int[][] grid) {
        int n = grid.length;
        return construct1(grid, 0, 0, n);
    }

    public Node construct1(int[][] grid, int i, int j, int n) {
        if (n == 1) {
            return new Node(grid[i][j] == 1, true, null, null, null, null);
        }
        int len = n / 2;
        Node topLeft = construct1(grid, i, j, len);
        Node topRight = construct1(grid, i, j + len, len);
        Node bottomLeft = construct1(grid, i + len, j, len);
        Node bottomRight = construct1(grid, i + len, j + len, len);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
                return new Node(true, true, null, null, null, null);
            } else if (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val) {
                return new Node(false, true, null, null, null, null);
            }
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
