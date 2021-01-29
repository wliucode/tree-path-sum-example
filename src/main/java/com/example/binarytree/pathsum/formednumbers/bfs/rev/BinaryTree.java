package com.example.binarytree.pathsum.formednumbers.bfs.rev;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
    Question:
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.
    Find the total sum of all root-to-leaf numbers.
    Note: A leaf is a node with no children.

    Example 1:
        Input: [1,2,3]
          1
         / \
        2   3
        Output: 25

    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

    Example 2:
    Input: [1,2,3,4,5]
          1
         / \
        2   3
       / \
      4   5
    Output: 262
    Explanation:
    The root-to-leaf path 1->2->4 represents the number 124.
    The root-to-leaf path 1->2->5 represents the number 125.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 124 + 125 + 13 = 262.
 */

/*
    Solution 1:
    BFS (Breadth-first search) traversal

    The idea is to find all the paths from root to leaf in binary tree using BFS (Breadth-first search) traversal,
        and calculate sum of all the numbers which are formed from root to leaf paths

    For BFS (Breadth-first search) traversal,
        1. First of all, we create a new class (NodeAndSum) which wrap current node of tree and sum as a whole.
                initially current sum is 0 since no node is above root node.
        2. we create a queue (FIFO) for BFS and enqueue the instance of wrapper class (NodeAndSum)
        3. we dequeue an instance of wrapper class, calculate next sum as (current sum)*10 plus node's data
        4. if current node is leaf, add next sum to total sum
        5. if current node has left child, put new instance of wrapper class
                which contain left child fo current node and next sum
        7. if current node has right child, put new instance of wrapper class
                which contain right child as current node and next sum
        8, Repeat steps from 3 to 7 till queue is empty, then return total sum.
 */
public class BinaryTree {

    public static class Node {
        int data;
        Node left = null;
        Node right = null;

        public Node (int val){
            this.data = val;
        }
    }

    static class NodeAndSum {
        Node node;
        int sum;

        NodeAndSum (Node node, int val){
            this.node = node;
            this.sum = val;
        }
    }

    /*
        The function do BFS (Breadth-first search) traversal.
        It does iterative traversal to keep tracking the path from root and leaf using queue
            and calculate the current sum;
        Once a path from root and leaf is found, it will add current sum to total sum;
        Once queue is empty, total sum will be returned.
     */
    public static int treePathsSumBFS(Node root) {

        if (root == null) {
            return 0;
        }

        Queue<NodeAndSum> queueNodeAndSum = new LinkedList<>();
        queueNodeAndSum.add(new NodeAndSum(root, 0));

        int totalSum = 0;

        while(!queueNodeAndSum.isEmpty()){
            NodeAndSum head = queueNodeAndSum.poll();

            int currSum = head.sum * 10 + head.node.data;

            if(head.node!=null && head.node.left== null && head.node.right==null){
                System.out.println("Total sum before adding next sum for formed Path from root to leaf: " + totalSum + ";");
                System.out.println("The number formed by the path from root to leaf: " + currSum + ";");
                totalSum += currSum;
                System.out.println("Total sum after adding next sum for formed Path from root to leaf: " + totalSum + ";");
                System.out.println();
            }

            if(head.node!=null && head.node.left!=null){
                queueNodeAndSum.add(new NodeAndSum (head.node.left, currSum));
            }

            if(head.node!=null && head.node.right!=null){
                queueNodeAndSum.add(new NodeAndSum (head.node.right, currSum));
            }
        }

        return totalSum;
    }

    public static void main (String[] args){
        Node root = null;
        int sum = 0;

        System.out.println("Test case 1: ");
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println("Calculate the sum of all the numbers of paths from root to leaf iteratively.");
        System.out.println();
        sum = treePathsSumBFS(root);
        System.out.println("Sum of all the numbers of paths iteratively (BFS): " + sum);
        System.out.println();

        System.out.println("Test case 2: ");
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Calculate the sum of all the numbers of paths from root to leaf iteratively.");
        System.out.println();
        sum = treePathsSumBFS(root);
        System.out.println("Sum of all the numbers of paths iteratively (BFS) : " + sum);
        System.out.println();
    }
}
