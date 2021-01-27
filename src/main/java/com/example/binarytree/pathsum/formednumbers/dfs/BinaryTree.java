package com.example.binarytree.pathsum.formednumbers.dfs;

/*
    Solution 2:
    DFS (Depth-first search) traversal

    Solution:
    The idea is to find all the path from root to leaf in binary tree using DFS (Depth-first search) traversal,
        and calculate sum of all the numbers which are formed from root to leaf paths

    For DFS (Depth-first search) traversal. main function will recursively call treePathsSumDFSUtil()
        by passing current node and value
            for current node, let the value be val,
                and check if the node is the leaf node or not.
                If the node is the leaf node, return the val
            for every node, the val will be updated as val*10 plus node's data
 */

public class BinaryTree {

    public static class Node {

        int data;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.data = val;
        }
    }

    static int treePathsSumDFSUtil(Node node, int val)
    {
        // Base case
        if (node == null)
            return 0;

        // Update val as val*10 plus node's data
        val = (val * 10 + node.data);

        // if current node is leaf, return the current node's val
        if (node.left == null && node.right == null)
            return val;

        // recur sum of values for left and right subtree
        return treePathsSumDFSUtil(node.left, val)
                + treePathsSumDFSUtil(node.right, val);
    }

    // The function do DFS (Depth-first search) traversal.
    // It uses treePathsSumUtil() recursively
    static int treePathsSumDFS(Node node)
    {
        // Pass the initial value as 0 as there is nothing above root
        return treePathsSumDFSUtil(node, 0);
    }

    public static void main (String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int sum = 0;

        sum =  treePathsSumDFS(root);
        System.out.println("Sum of all path using recursion : " + sum);
        System.out.println();
    }
}
