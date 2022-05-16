package com.sample.TREE;

import java.util.*;
public class IdenticalTrees {
	static class Node {
		int data;
		Node left;
		Node right;
	}
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node .right = null;
		return node;
	}
	
	static int isIdentical(Node root1,Node root2) {
		if (root1.left == root2.left && root1.right == root2.right
				&& root1.data == root2.data) {
			return 1;
		}else {
			return 0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root1 = newNode(10);
		Node root2 = newNode(10);
		root1.left = newNode(20);
		root2.left = newNode(20);
		root1.right = newNode(30);
		root2.right = newNode(30);
		root1.left.left = newNode(40);
		root2.left.left = newNode(40);
		root1.right.right = newNode(60);
		root2.right.right = newNode(60);
		
		if (isIdentical(root1, root2)==1)
	        System.out.print("Both BSTs are identical");
	    else
	        System.out.print("BSTs are not identical");

	}

}
