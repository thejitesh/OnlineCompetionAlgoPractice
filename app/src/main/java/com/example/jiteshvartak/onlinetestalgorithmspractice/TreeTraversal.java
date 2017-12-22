package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class TreeTraversal {

	public static void main(String[] args) {

		Node leftleft = new Node();
		leftleft.data = 22;
		leftleft.left = null;
		leftleft.right = null;

		Node leftright = new Node();
		leftright.data = 23;
		leftright.left = null;
		leftright.right = null;

		Node left = new Node();
		left.data = 2;
		left.left = leftleft;
		left.right = leftright;

		Node right = new Node();
		right.data = 3;
		right.left = null;
		right.right = null;

		Node root = new Node();
		root.data = 1;
		root.left = left;
		root.right = right;

		intOrder(root);

	}

	// -----------------
	static class Node {
		int data;
		Node left;
		Node right;
	}

	static void preOrder(Node root) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}
		System.out.print(root.data + " ");
		if (root.left != null) {
			preOrder(root.left);
		}

		if (root.right != null) {
			preOrder(root.right);
		}
	}

	static void postOrder(Node root) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}

	static void intOrder(Node root) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}

		intOrder(root.left);
		System.out.print(root.data + " ");
		intOrder(root.right);
	}

}
