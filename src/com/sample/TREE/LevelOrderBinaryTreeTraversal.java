package com.sample.TREE;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBinaryTreeTraversal {
	Node root;
	void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {            
            Node tempNode = queue.poll(); //// poll() removes the present head.
            System.out.print(tempNode.data + " ");
            
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }	
	
	public static void main(String[] args) {
        /* creating a binary tree and entering  the nodes */
		LevelOrderBinaryTreeTraversal tree_level = new LevelOrderBinaryTreeTraversal();
       tree_level.root = new Node(1);
       tree_level.root.left = new Node(2);
       tree_level.root.right = new Node(3);
       tree_level.root.left.left = new Node(4);
       tree_level.root.left.right = new Node(5);
       System.out.println("Level order traversal of binary tree is - ");
       tree_level.printLevelOrder();

	}

}

class Node {
    int data;
    Node left, right;	 
    public Node(int item)
    {
        data = item;
        left = null;
        right = null;
    }
}


//Level order traversal of a tree is breadth first traversal for the tree.
//https://www.geeksforgeeks.org/level-order-tree-traversal/
/*
Method 2 (Using queue_LinkedList)
Algorithm: 
For each node, first the node is visited and then it’s child nodes are put in a FIFO queue. 
printLevelorder(tree)

1) Create an empty queue q
2) temp_node = root //start from root
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children 
      (first left then right children) to q
    c) Dequeue a node from q.
*/    