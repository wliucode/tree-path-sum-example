# Task

    Find the total sum of all root-to-leaf numbers.

# Requirement

    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.
    Find the total sum of all root-to-leaf numbers.
    Note: A leaf is a node with no children.

    Example:
        Input: [1,2,3]
          1
         / \
        2   3
        Output: 25

    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

# Solution

    1. Pass the root of binary tree by reference for the calling method
    2. Solution 1 (Original Version): BFS (Breadth-first search) traversal
        2.1 Find all the paths from root to leaf in binary tree using iterative approach (BFS)
        2.2 Two main queues are created, one for maintaining each node, another one for maintaining the Paths
        2.3 And then calculate sum of all the numbers which are formed by each path from root to leaf
        2.4 The sum will be updated as sum*10 plus node's data when we iterate each path
        2.5 Time Complexity : O(n) - where n is the number of nodes in the given binary tree.
        2.6 Space Complexity: O(n) - where n is the number of nodes in the given binary tree.
    3. Solution 1 (**Revised Version)**: BFS (Breadth-first search) traversal
        3.1 First of all, we create a new class (NodeAndSum) which wrap current node of tree and sum as a whole. 
                initially current sum is 0 since no node is above root node.
        3.2 We create a queue (FIFO) for BFS and enqueue the instance of wrapper class (NodeAndSum)
        3.3 we dequeue an instance of wrapper class, calculate next sum as (current sum)*10 plus node's data
        3.4 if current node is leaf, add next sum to total sum
        3.5 if current node has left child, put new instance of wrapper class 
                which contain left child fo current node and next sum
        3.6. if current node has right child, put new instance of wrapper class
                which contain right child as current node and next sum
        3.7 Repeat steps from 3.3 to 3.6 till queue is empty, then return total sum.                     
    3. Solution 2: DFS (Depth-first search) traversal
        3.1 Find all the paths from root to leaf in binary tree using recursive approach (DFS)
        3.2 Main method will recursively call treePathsSumDFSUtil() by passing current node and value
        3.3 Once current node is a leaf node, the val will be updated as val*10 plus node's data
        3.4 Time Complexity : O(n) - where n is the number of nodes in the given binary tree.  
    4. Total line of code comparison Solution 1 (BFS approcah) vs. Solution 2 (DFS aproach)
        4.1 Solution 1 (Original Version) (BFS approach) - 88 lines
        4.2 Solution 1 (**Revised** Version) (BFS approach) - 34 lines        
        4.3 Solution 2 (DFS approach) - 24 lines

# Test cases

    Write test case through JUnit.
    
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