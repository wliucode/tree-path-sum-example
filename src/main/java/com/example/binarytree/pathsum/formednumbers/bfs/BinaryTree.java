package com.example.binarytree.pathsum.formednumbers.bfs;

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
        1. First of all, we create a FIFO queue to do Level order traversal for Binary Tree
                it will keep track of each node, and then left child & right child, and so on
                this FIFO queue is implemented by a Linked List
        2. Secondly, we create another FIFO queue to keep track of all the paths from root to current node
        the path from root to current node simultaneously
        3. Thirdly, we also create temporary FIFO queue to keep track of each path and enqueue to the 2nd queue
        4. Fourthly, if current node is leaf, calculate the sum of the formed number
                by iterating the path from root to leaf to figure out the val
                and val will be updated as val*10 plus node's data
        5. Fifthly, the total sum will be all the numbers formed by the path from root to leaf
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

    /*
        The function do BFS (Breadth-first search) traversal.
        It does iterative traversal using two Queues, one for maintaining each node, another one maintain the Paths
        Once a path from root and leaf is found, it will calculate the sum based on the formed number,
            and then add to total sum;
     */
    public static int treePathsSumBFS(Node root) {

        int sum = 0;

        int totalPath = 0;

        // Base case
        if (root == null) {
            return 0;
        }

        Queue<Node> queueNode = new LinkedList<>();

        Queue<Queue<Integer>> queuePaths = new LinkedList<>();
        Queue<Integer> queuePath = new LinkedList<>();

        queueNode.add(root);

        queuePath.add(root.data);
        queuePaths.add(queuePath);

        while(!queueNode.isEmpty()){
            Node head = (Node) queueNode.poll();
            Queue<Integer> headPath = queuePaths.poll();

            // if current node is leaf, calculate sum of formed number of path from root to leaf
            if(head.left== null && head.right==null){
                System.out.println("Calculate the sum for queue Path " + ++totalPath + " : ");

                sum += sumQueueUtil(headPath);
                System.out.println();
                continue;
            }

            if(head.left!=null){
                queueNode.add(head.left);
                Queue<Integer> leftHeadPath = copyQueueUtil(headPath);
                leftHeadPath.add(head.left.data);
                queuePaths.add(leftHeadPath);
            }

            if(head.right!=null){
                queueNode.add(head.right);
                Queue<Integer> rightHeadPath = copyQueueUtil(headPath);
                rightHeadPath.add(head.right.data);
                queuePaths.add(rightHeadPath);
            }
        }

        return sum;
    }

    private static Queue<Integer> copyQueueUtil(Queue<Integer> headPath) {

        Queue<Integer> q = new LinkedList<>();
        Iterator<Integer> itr = headPath.iterator();

        while(itr.hasNext()){
            q.add(itr.next());
        }
        return q;
    }

    // Start popping nodes from Path (queue) and calculate the sum and print them
    public static int sumQueueUtil(Queue<Integer> qPaths) {

        int sum = 0;

        // Start popping nodes from Path (queue)
        int i = 0;

        Iterator<Integer> itr = qPaths.iterator();

        while(itr.hasNext()){
            Integer curr = itr.next();

            // Update and calculate the sum
            sum = sum*10 + curr;

            // print them for testing
            System.out.print("Iteration " + ++i + ": "
                                + " (value is " + curr + "), "
                                + "(current sum is " + sum + "); ");
        }

        System.out.println();

        return sum;
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
        System.out.println("Sum of all the numbers of paths iteratively : " + sum);
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
        System.out.println("Sum of all the numbers of paths iteratively : " + sum);
        System.out.println();
    }
}
