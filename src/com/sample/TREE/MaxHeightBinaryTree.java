package com.sample.TREE;

public class MaxHeightBinaryTree {
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	Node root;
	public static int findHeight(Node temp) {
		int rootNodeHeight = 1;
		int leftHeight = 0;
		int rightHeight = 0;
		if(temp.left != null) {
			leftHeight = findHeight(temp.left);
		}
		if(temp.right != null) {
			rightHeight = findHeight(temp.right);
		}		
		int maxHeight = (leftHeight > rightHeight)?leftHeight:rightHeight;
		return (maxHeight+rootNodeHeight);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeightBinaryTree bt = new MaxHeightBinaryTree();
        //Add nodes to the binary tree  
        bt.root = new Node(1);  
        bt.root.left = new Node(2);  
        bt.root.right = new Node(3);  
        bt.root.left.left = new Node(4);  
        bt.root.right.left = new Node(5);  
        bt.root.right.right = new Node(6);  
        bt.root.right.right.right= new Node(7);  
        bt.root.right.right.right.right = new Node(8);  
  
        //Display the maximum height of the given binary tree  
        System.out.println("Maximum height of given binary tree: " + bt.findHeight(bt.root));  
	}

}
