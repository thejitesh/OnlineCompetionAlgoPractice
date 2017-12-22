package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;

class StackHeight {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int s1 = scanner.nextInt();
		int s2 = scanner.nextInt();
		int s3 = scanner.nextInt();

		Node arr1[] = new Node[s1];
		Node arr2[] = new Node[s2];
		Node arr3[] = new Node[s3];

		for (int i = 0; i < s1; i++) {
			int value = scanner.nextInt();
			Node node = new Node();
			node.value = value;
			arr1[i] = node;
		}

		for (int i = 0; i < s2; i++) {
			int value = scanner.nextInt();
			Node node = new Node();
			node.value = value;
			arr2[i] = node;
		}

		for (int i = 0; i < s3; i++) {
			int value = scanner.nextInt();
			Node node = new Node();
			node.value = value;
			arr3[i] = node;
		}

		for (int i = s1 - 1; i >= 0; i--) {
			setUpStack(arr1, i, s1);
		}

		for (int i = s2 - 1; i >= 0; i--) {
			setUpStack(arr2, i, s2);
		}

		for (int i = s3 - 1; i >= 0; i--) {
			setUpStack(arr3, i, s3);
		}

		if (s1 < s2 && s1 < s3) {
			doIt(arr1, arr2, arr3);
		} else if (s2 < s1 && s2 < s3) {
			doIt( arr2,arr1, arr3);
		} else if (s3 < s1 && s3 < s2) {
			doIt(arr3,arr1, arr2);
		} else {
			doIt(arr1, arr2, arr3);
		}

		scanner.close();
	}

	private static void doIt(Node[] arr1, Node[] arr2, Node[] arr3) {
		for (int i = arr1.length - 1; i >= 0; i--) {

			int stack1Height = arr1[i].height;

			int stack2Index = arr2.length - 1;
			int stack3Index = arr3.length - 1;
			while (true) {

				int stack2Height = arr2[stack2Index].height;
				if (stack1Height > stack2Height) {
					stack2Index--;
					if(stack2Index<0){
						stack2Index =0;
					}
				} else if (stack1Height < stack2Height) {
					break;
				}

				int stack3Height = arr3[stack3Index].height;
				if (stack1Height > stack3Height) {
					stack3Index--;
					if(stack3Index<0){
						stack3Index =0;
					}
						
				} else if (stack1Height < stack3Height) {
					break;
				}

				if (stack1Height == stack2Height && stack2Height == stack3Height) {

					print(stack1Height + "");
					break;
				}

			}

		}
	}

	static void setUpStack(Node[] arr, int i, int size) {

		Node node = arr[i];
		if (i == size - 1) {
			node.height = node.value;
		} else {

			node.height = node.value + arr[i + 1].height;
		}
	}

	static class Node {
		int value;
		int height;
	}

	static void print(String str) {
		System.out.println(str);
	}

}