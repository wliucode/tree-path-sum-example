package com.example.binarytree.pathsum.formednumbers.bfs.rev;

import com.example.binarytree.pathsum.formednumbers.bfs.rev.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

    @Test
    public void basicTests() {

        BinaryTree tree = new BinaryTree();

        BinaryTree.Node root = null;

        root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);

        assertEquals(25, tree.treePathsSumBFS(root));

        root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);

        assertEquals(262, tree.treePathsSumBFS(root));
    }
}
