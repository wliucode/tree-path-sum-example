package com.example.binarytree.pathsum.allnumbers;

/*
    Question:
    Give an algorithm for finding the sum of all elements in a binary tree.

    Example:
        Input: [1,2,3]
          1
         / \
        2   3
        Output: 6

    Explanation:
        sum = 1 + 2 + 3 = 6
 */

/*
    Solution for reference:
    Traverse the tree in any fashion (e.g. Preorder in this case),
        and check if the node is the leaf node or not.
        If the node is the leaf node, add node data to the sum.
 */
public class BinaryTree {

    static class Node {
        int data;
        Node left = null;
        Node right = null;

        Node (int val){
            this.data = val;
        }
    }

    static int pathSum(Node root){
        int sum = 0;

        if (root == null)
            return 0;

        sum = root.data +  pathSum(root.left) + pathSum(root.right);

        return sum;
    }


    public static void main (String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int sum = 0;

        sum = pathSum(root);

        System.out.println("Sum of binary tree: " + sum);
        System.out.println();
    }
}
